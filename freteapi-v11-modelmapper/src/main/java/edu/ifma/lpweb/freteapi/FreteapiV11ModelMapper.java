package edu.ifma.lpweb.freteapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class FreteapiV11ModelMapper {

	public static void main(String[] args) {
		SpringApplication.run(FreteapiV11ModelMapper.class, args);
	}

}
