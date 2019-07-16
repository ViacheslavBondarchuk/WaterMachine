package com.org.house;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableOAuth2Sso
@SpringBootApplication
//@EnableResourceServer
//@EnableAuthorizationServer
public class MainApp {

    public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
    }

}
