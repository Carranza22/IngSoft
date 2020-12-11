package net.cyancj.sistemae_cepuns;

import net.cyancj.sistemae_cepuns.config.AppMVC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class AppRun extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(AppMVC.class);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(AppMVC.class);
    }
}
