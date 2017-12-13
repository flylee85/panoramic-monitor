package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;

import com.cloud.util.LoggerUtils;
import com.cloud.util.TLogger;

/**
 * 使用Eureka做服务发现。
 */
@SpringBootApplication
@EnableEurekaServer
// @ComponentScan(basePackages = {"com.cloud"})
public class EurekaApplication {
	private static final transient TLogger DB_LOGGER = LoggerUtils.getLogger(EurekaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EurekaApplication.class, args);
		DB_LOGGER.warn("EurekaApplication started successfully");
	}
}
