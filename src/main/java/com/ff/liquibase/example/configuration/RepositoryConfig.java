package com.ff.liquibase.example.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManagerFactory;
import javax.sql.CommonDataSource;
import javax.sql.DataSource;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Properties;

@PropertySource("classpath:database.properties")
@Configuration
public class RepositoryConfig {

    private static final String HIBERNATE_PROPERTIES_RESOURCE = "hibernate.properties";
    private static final Properties HIBERNATE_PROPERTIES = readProperties();

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Value("${jdbc.driver}")
    private String driver;

    private static Properties readProperties() {
        try (BufferedInputStream is = new BufferedInputStream(ClassLoader.getSystemResourceAsStream(HIBERNATE_PROPERTIES_RESOURCE))) {
            Properties properties = new Properties();
            properties.load(is);
            return properties;
        } catch (IOException e) {
            throw new RuntimeException("Failed to read properties from scr/properties.");
        }
    }

    @Bean
    public HibernateJpaVendorAdapter jpaVendorAdaptor() {
        return new HibernateJpaVendorAdapter();
    }

    @Bean
    public DataSource dataSource() {
        /**
         * Pooled datasource.
         */
        org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();

        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driver);

        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
        lef.setDataSource(dataSource());
        lef.setJpaVendorAdapter(jpaVendorAdaptor());
        lef.setPackagesToScan("com.ff.liquibase.example.core.entity");
        lef.setJpaProperties(HIBERNATE_PROPERTIES);
        return lef;
    }
}