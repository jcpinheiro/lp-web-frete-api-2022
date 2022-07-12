package edu.ifma.lpweb.freteapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class FreteapiV10Cache {

	public static void main(String[] args) {
		SpringApplication.run(FreteapiV10Cache.class, args);
	}

}
