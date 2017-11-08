package com.invoke;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author sunder
 */
@SpringBootApplication
@EnableDiscoveryClient
public class InvokeApplication {
    public static void main(String[] args) {
        SpringApplication.run(InvokeApplication.class, args);
    }
}
