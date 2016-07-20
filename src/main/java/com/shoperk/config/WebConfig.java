package com.shoperk.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Collections;
import java.util.List;

/**
 * Created by DEV on 08.07.2016.
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.shoperk")
public class WebConfig extends WebMvcConfigurerAdapter{
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converterExtractors){

        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(new ObjectMapper());
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
        converterExtractors.add(converter);
    }

}
