package com.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

import com.cloud.util.LoggerUtils;
import com.cloud.util.TLogger;

/**
 * @author sunmer 启动类
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = { "com.cloud", "com.monitor" })
public class ManageApplication {
	private static final transient TLogger DB_LOGGER = LoggerUtils.getLogger(ManageApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ManageApplication.class, args);
		DB_LOGGER.warn("ManageApplication started successfully");
	}
}
