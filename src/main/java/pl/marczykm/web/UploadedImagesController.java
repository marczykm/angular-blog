package pl.marczykm.web;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.marczykm.domain.Configuration;
import pl.marczykm.service.ConfigurationService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by MMARCZYK on 2016-01-27.
 */
@RestController
@RequestMapping("/uploads")
public class UploadedImagesController {

    private ConfigurationService configurationService;

    @Autowired
    public UploadedImagesController(ConfigurationService configurationService) {
        this.configurationService = configurationService;
    }

    @RequestMapping()
    public byte[] getImage(@RequestParam("name") String name) {
        File file = new File(configurationService.getUploadPath() + name);
        try {
            FileInputStream fis = new FileInputStream(file);
            return IOUtils.toByteArray(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
