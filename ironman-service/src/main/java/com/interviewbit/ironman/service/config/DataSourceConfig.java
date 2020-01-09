package com.interviewbit.ironman.service.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Primary
    @Bean(name = "dataSource")
    @ConfigurationProperties(prefix = "spring.master.datasource")
    public DataSource dataSource(){ return DataSourceBuilder.create().build(); }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager jpaTxManager(){
        JpaTransactionManager txMan = new JpaTransactionManager();
        txMan.setDataSource(dataSource());
        return txMan;
    }

}
