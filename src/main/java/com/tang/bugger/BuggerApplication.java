package com.tang.bugger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = { "com.tang" })
public class BuggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuggerApplication.class, args);
	}
}
