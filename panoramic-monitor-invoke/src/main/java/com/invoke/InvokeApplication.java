package com.invoke;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author sunder
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = { "com.cloud", "com.invoke"})
public class InvokeApplication  {
    public static void main(String[] args) {
        SpringApplication.run(InvokeApplication.class, args);
    }
}
