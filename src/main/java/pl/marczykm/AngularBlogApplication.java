package pl.marczykm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class AngularBlogApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AngularBlogApplication.class).properties("spring.config.name:my-blog");
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(AngularBlogApplication.class).properties("spring.config.name:my-blog").build().run(args);
    }


}
