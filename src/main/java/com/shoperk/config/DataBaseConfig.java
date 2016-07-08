package com.shoperk.config;

import com.oracle.webservices.internal.api.message.PropertySet;
import org.omg.CORBA.Environment;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;

@Configuration
@EnableJpaRepositories("com.shoperk.repository")
@EnableTransactionManagement
@PropertySource("classpath:db.properties")
@ComponentScan("com.shoperk")
public class DataBaseConfig {
    @Resource
    private Environment env;
}
