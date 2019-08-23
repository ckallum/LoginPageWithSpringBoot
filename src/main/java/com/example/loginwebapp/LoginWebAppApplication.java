package com.example.loginwebapp;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
@MapperScan("com.example.loginwebapp.dao")
public class LoginWebAppApplication implements CommandLineRunner{

    private Logger log = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        SpringApplication.run(LoginWebAppApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Running");
    }

    @Bean
    public CommandLineRunner runner(ApplicationContext context){
        return args-> {
            System.out.println("Beans: ");
            String[] beanNames = context.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String bean:beanNames) {
                System.out.println(bean);
            }
        };
    }

}
