package com.start.mavenbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class MavenBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(MavenBookApplication.class, args);
    }

    @GetMapping
    public String HelloWorld() {
        return "Hello! Maven Spring!";
    }

}
