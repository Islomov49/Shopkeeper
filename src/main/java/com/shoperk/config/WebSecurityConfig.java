package com.shoperk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import com.shoperk.security.UsersDetailsService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by DEV on 21.07.2016.
 */
@Configuration
@EnableWebMvcSecurity
@ComponentScan(basePackageClasses = UsersDetailsService.class)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter  {



    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth,
                                UsersDetailsService userDetailsService)throws Exception{
        auth.userDetailsService(userDetailsService)
        //        .passwordEncoder(passwordencoder())
        ;

    }

    @Override
    protected void configure(HttpSecurity httpSecurity)throws Exception{

        httpSecurity.
                authorizeRequests()

                .antMatchers("/test")
                .permitAll()
                .antMatchers("/ananim/put")
                .permitAll()

                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                // for customize login controller
                //.loginPage("/login")
                //.permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .httpBasic();
    }

    @Bean(name="passwordEncoder")
    public PasswordEncoder passwordencoder(){
        return new BCryptPasswordEncoder();
    }
}
