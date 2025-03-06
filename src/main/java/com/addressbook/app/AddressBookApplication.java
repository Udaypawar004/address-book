package com.addressbook.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class AddressBookApplication {

	public static void main(String[] args) {
		log.info("Application started...");
		SpringApplication.run(AddressBookApplication.class, args);
	}

}
