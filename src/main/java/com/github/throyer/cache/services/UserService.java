package com.github.throyer.cache.services;

import com.github.throyer.cache.models.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

import static java.lang.String.format;

@Slf4j
@Service
public class UserService {
    private final RestTemplate template = new RestTemplate();

    @Cacheable("users")
    public User findByUsername(String username) {
        try {
            log.info("method={}, message={}", "findByUsername", format("searching user by: %s", username));
            var response = template.getForEntity("https://api.github.com/users/{username}", User.class, username);
            return Objects.requireNonNull(response.getBody(), "response body is null");
        } catch (HttpStatusCodeException exception) {
            log.error("method={}, error={}, body={}", "findByUsername", exception.getMessage(), exception.getResponseBodyAsString());
            throw exception;
        }
    }
}
