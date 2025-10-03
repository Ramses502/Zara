package com.project.zara;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.project")
@EnableJpaRepositories(basePackages = "com.project")
@EntityScan(basePackages = "com.project")
public class ZaraApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZaraApplication.class, args);
	}

}
