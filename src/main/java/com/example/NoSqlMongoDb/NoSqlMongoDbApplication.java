package com.example.NoSqlMongoDb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class NoSqlMongoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(NoSqlMongoDbApplication.class, args);
	}

}
