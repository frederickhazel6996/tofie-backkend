package com.hazex.tofiebackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class TofieBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(TofieBackendApplication.class, args);
	}

}
