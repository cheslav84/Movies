package com.gfl.havryliuk.movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.gfl.havryliuk.movies.model.repository")
@EntityScan("com.gfl.havryliuk.movies.model.entity")
@SpringBootApplication
public class MoviesApplication {


	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}

}
