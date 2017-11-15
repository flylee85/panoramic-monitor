package com.invoke;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.invoke.web.filter.GateWayAuthenticationFilter;

/**
 * @author sunder
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = { "com.cloud", "com.invoke" })
public class InvokeApplication {
	public static void main(String[] args) {
		SpringApplication.run(InvokeApplication.class, args);
	}

//	@Bean
//	public FilterRegistrationBean gateWayAuthenticationFilter() {
//		FilterRegistrationBean registration = new FilterRegistrationBean();
//		registration.setFilter(new GateWayAuthenticationFilter());
//		registration.addUrlPatterns("/gateway/*");
//		registration.addInitParameter("params", "paramValues");
//		registration.setName("GateWayAuthenticationFilter");
//		registration.setOrder(1);
//		return registration;
//	}
}
