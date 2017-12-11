package com.risk.warning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author sunmer
 * 启动类
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.cloud", "com.risk"})
public class RiskWarningApplication {
    public static void main(String[] args) {
        SpringApplication.run(RiskWarningApplication.class, args);
    }
}
