package com.tulio.validationcnpj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ValidationCNPJApplication {

	public static void main(String[] args) {
		SpringApplication.run(ValidationCNPJApplication.class, args);
	}

}
