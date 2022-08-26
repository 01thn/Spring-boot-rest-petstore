package com.thn.restpetstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.thn.restpetstore.repository")
@EnableMongoRepositories(basePackages = "com.thn.restpetstore.mongo")
public class RestPetstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestPetstoreApplication.class, args);
    }

}
