package com.github.throyer.cache.controllers;

import com.github.throyer.cache.services.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.String.format;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UsersController {
    private final UserService service;

    @GetMapping("/{username}")
    public Object show(@PathVariable("username") String username) {
        log.info("method={}, message={}", "show", format("searching user: %s", username));
        return service.findByUsername(username);
    }
}
