package com.github.throyer.cache.cache;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import static java.lang.String.format;
import static java.lang.String.join;
import static java.util.Optional.ofNullable;
import static java.util.concurrent.TimeUnit.MINUTES;

@Slf4j
@Component
@AllArgsConstructor
public class CleanCacheSchedule {
    private final CacheManager manager;

    @Scheduled(fixedDelayString = "${cache.time-to-expire-in-minutes}", timeUnit = MINUTES)
    public void clean() {
        log.info("method={}, message={}", "clean", "executando rotina que limpa os caches");

        var names = manager.getCacheNames();

        if (names.isEmpty()) {
            log.info("method={}, message={}", "clean", "cache vazio, nenhum valor encontrado");
            return;
        }

        log.info("method={}, message={}", "clean", format("limpando os caches: [%s]", join(", ", names)));

        names.forEach(name -> ofNullable(manager.getCache(name))
            .ifPresent(Cache::clear));
    }
}
