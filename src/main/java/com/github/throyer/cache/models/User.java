package com.github.throyer.cache.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Long id;
    private String name;

    @JsonProperty("avatar_url")
    private String avatarUrl;
}
