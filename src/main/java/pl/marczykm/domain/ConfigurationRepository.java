package pl.marczykm.domain;


import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by MMARCZYK on 2016-01-27.
 */
public interface ConfigurationRepository extends Repository<Configuration, Long> {
    List<Configuration> findAllByOrderByCreationDateDesc();
    Configuration save(Configuration configuration);
}
