package org.languano.http;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
public class WordsController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/words")
    public Words greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Words(counter.incrementAndGet(), String.format(template, name));
    }
}