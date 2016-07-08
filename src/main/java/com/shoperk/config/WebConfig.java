package com.shoperk.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by DEV on 08.07.2016.
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.shoperk")
public class WebConfig extends WebMvcConfigurerAdapter{

}
