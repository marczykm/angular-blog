package pl.marczykm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.marczykm.domain.Configuration;
import pl.marczykm.domain.ConfigurationRepository;

import java.util.List;

/**
 * Created by MMARCZYK on 2016-01-27.
 */
@Service
public class ConfigurationService {

    private ConfigurationRepository configurationRepository;
    private Configuration configuration;

    @Autowired
    public ConfigurationService(ConfigurationRepository configurationRepository) {
        this.configurationRepository = configurationRepository;
    }

    public String getAuthor() {
        if (configuration == null){
            List<Configuration> configurations = configurationRepository.findAllByOrderByCreationDateDesc();
            if (configurations.isEmpty()) {
                throw new RuntimeException("No configuration found");
            }
            configuration = configurations.get(0);
        }
        return configuration.getAuthor();
    }

}

