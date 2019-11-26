package com.netflix.filme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(basePackages = { "com.netflix.filme*" })
@EnableSpringDataWebSupport
@EnableAutoConfiguration
@EnableSwagger2
@EnableEurekaClient
public class FilmeApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilmeApplication.class, args);
	}

}
