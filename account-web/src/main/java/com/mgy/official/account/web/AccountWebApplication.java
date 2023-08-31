package com.mgy.official.account.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.mgy.official.account"})
public class AccountWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountWebApplication.class, args);
    }

}
