package org.languano;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class LanguaneApplication {
    public static void main(String[] args) {
        SpringApplication.run(LanguaneApplication.class, args);
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Your initialization code here
        System.out.println("Application started");
    }
}