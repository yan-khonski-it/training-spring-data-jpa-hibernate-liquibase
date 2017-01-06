package com.ff.liquibase.example.configuration;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;

@Configuration
@ComponentScan({"com.ff.liquibase.example"})
@Import({RepositoryConfig.class})
public class AppConfig {

    private static final String APPLICATION_PROPERTIES_PATH = "application.properties";

    //<context:property-placeholder location="classpath:application.properties" />
    @Bean
    public PropertyPlaceholderConfigurer getPropertyPlaceholderConfigurer() {
        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        ppc.setLocation(new ClassPathResource(APPLICATION_PROPERTIES_PATH));
        ppc.setIgnoreUnresolvablePlaceholders(true);
        return ppc;
    }
}
