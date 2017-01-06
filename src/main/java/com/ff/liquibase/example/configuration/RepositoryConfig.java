package com.ff.liquibase.example.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.CommonDataSource;
import javax.sql.DataSource;

@Configuration
public class RepositoryConfig {

    //${jdbc.driverClassName}
    @Value("${hibernate.connection.driver_class}")
    private String driverClassName;
    @Value("${jdbc.url}")
    private String url;
    @Value("${hibernate.connection.username}")
    private String username;
    @Value("${hibernate.connection.password}")
    private String password;

    @Value("${hibernate.dialect}")
    private String hibernateDialect;
    @Value("${hibernate.show_sql}")
    private String hibernateShowSql;
    @Value("${hbm2ddl.auto")
    private String hibernateHbm2ddlAuto;

    @Bean
    public HibernateJpaVendorAdapter getJpaVendorAdaptor() {
        return new HibernateJpaVendorAdapter();
    }

    /**
     * Pooled datasource.
     */
    @Bean
    public CommonDataSource getDataSource() {
        org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClassName);

        return dataSource;
    }


}