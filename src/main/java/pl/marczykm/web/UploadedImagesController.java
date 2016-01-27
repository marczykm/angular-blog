package pl.marczykm.web;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.marczykm.service.ConfigurationService;

import java.io.File;
import java.io.FileInputStream;
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

    @RequestMapping("/{name:.+}")
    public byte[] getImage(@PathVariable("name") String name) throws IOException {
        return IOUtils.toByteArray(new FileInputStream(new File(configurationService.getUploadPath() + name)));
    }
}
