package com.netflix.filmelistener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.netflix.filmelistener*" })
@EnableAutoConfiguration
@EnableEurekaClient
public class FilmeListenerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilmeListenerApplication.class, args);
	}

}
