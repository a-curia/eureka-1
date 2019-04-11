package com.dbbyte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AcMovieInfoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcMovieInfoServiceApplication.class, args);
	}

}
