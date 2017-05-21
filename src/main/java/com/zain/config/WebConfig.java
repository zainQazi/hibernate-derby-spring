package com.zain.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by qhasan on 5/21/2017.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.zain.controller")
public class WebConfig extends WebMvcConfigurerAdapter{


}
