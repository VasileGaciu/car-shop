package com.car.shop;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@Log4j2
public class CarShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarShopApplication.class, args);
		log.info("--------------Hello world-------------");
	}

}
