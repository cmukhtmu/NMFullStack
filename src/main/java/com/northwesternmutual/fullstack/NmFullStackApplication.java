package com.northwesternmutual.fullstack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan ({"com.northwesternmutual.fullstack"})
public class NmFullStackApplication {

	public static void main(String[] args) {
		SpringApplication.run(NmFullStackApplication.class, args);
	}

}
