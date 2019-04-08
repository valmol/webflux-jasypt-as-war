package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/password")
public class DemoController {

    @Autowired
    private DemoProperties properties;

    @Value("${app.password: empty}")
    private String password;

    @GetMapping
    public Mono<String> getPassword() {
        return Mono.just("Type-safe value " + properties.getPassword() + "\n@Value: " + password);
    }

}
