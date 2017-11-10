package com.invoke;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author sunder
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = { "com.invoke", "com"})
public class InvokeApplication {
    public static void main(String[] args) {
        SpringApplication.run(InvokeApplication.class, args);
    }
}
