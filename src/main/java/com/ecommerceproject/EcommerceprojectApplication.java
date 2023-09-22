package com.ecommerceproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories
public class EcommerceprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceprojectApplication.class, args);
	}
}
