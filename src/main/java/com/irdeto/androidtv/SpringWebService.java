package com.irdeto.androidtv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.irdeto.androidtv"})
public class SpringWebService {

	public static void main(String[] args) {
        SpringApplication.run(SpringWebService.class, args);
	}

}
