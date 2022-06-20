package com.fmi.merchandise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.fmi.merchandise"})
@EnableJpaRepositories(basePackages = {"com.fmi.merchandise"})
public class MerchandiseApplication {

	public static void main(String[] args) {
		SpringApplication.run(MerchandiseApplication.class, args);
	}

}
