package com.codetest.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@EnableConfigurationProperties
@EntityScan("com.codetest.entity")
public class SpringJdbcConfig {
	
	@Autowired
	private Environment env;
	
    @Bean
    public DataSource mysqlDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(env.getProperty("DBURL"));
        dataSource.setUsername(env.getProperty("DBUSER"));
        dataSource.setPassword(env.getProperty("DBPASSWORD"));

        return dataSource;
    }
}
