package com.monitor.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author sunder
 * 启动类
 * 在classpath 下 两种格式是相同的
 * @EnableEurekaClient 更依赖于eureka注册中心
 * @EnableDiscoveryClient 可以在eureka中心或者zk，consul.所以更通用
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ManageApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManageApplication.class, args);
    }
}



