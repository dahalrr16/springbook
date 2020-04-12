package com.train.book.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan(basePackages = "com.train.book")
@SpringBootApplication
public class SpringbookApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbookApplication.class, args);
	}

}
