package com.pikmy.beta;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan("com.pikmy.controllers")
@EnableWebMvc
public class PikmyConfiguration extends WebMvcConfigurerAdapter {

}
