package edu.ifma.lpweb.freteapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class FreteapiV12ModelMapper {

	public static void main(String[] args) {
		SpringApplication.run(FreteapiV12ModelMapper.class, args);
	}

}
