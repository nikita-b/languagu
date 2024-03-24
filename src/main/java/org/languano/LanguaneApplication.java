package org.languano;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.languano.Telegram;

@SpringBootApplication
public class LanguaneApplication {
    public static void main(String[] args) {
        SpringApplication.run(LanguaneApplication.class, args);
        Telegram telegram = new Telegram();
        telegram.run();
    }
}