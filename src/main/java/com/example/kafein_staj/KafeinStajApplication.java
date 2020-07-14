package com.example.kafein_staj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("com.example.kafein_staj.entity")
@SpringBootApplication
public class KafeinStajApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafeinStajApplication.class, args);
	}

}
