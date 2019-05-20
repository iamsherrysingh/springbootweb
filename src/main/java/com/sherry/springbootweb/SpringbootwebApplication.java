package com.sherry.springbootweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootwebApplication {

    public static void main(String[] args)
    {
        ConfigurableApplicationContext context= SpringApplication.run(SpringbootwebApplication.class,args);

    }



}
