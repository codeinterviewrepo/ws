package com.codetest.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
 
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({"com.codetest","code.codetest.rest"})
public class RestApplication extends org.springframework.boot.web.servlet.support.SpringBootServletInitializer 
{
    public static void main(String[] args) 
    {
        new RestApplication().configure(new SpringApplicationBuilder(RestApplication.class)).run(args);
    }
    
}

