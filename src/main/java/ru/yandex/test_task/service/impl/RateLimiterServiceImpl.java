package ru.yandex.test_task.service.impl;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;
import io.github.bucket4j.Refill;
import org.springframework.stereotype.Service;
import ru.yandex.test_task.service.RateLimiterService;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class RateLimiterServiceImpl implements RateLimiterService {

    Map<String, Bucket> bucketCache = new ConcurrentHashMap<>();
    @Override
    public Bucket resolveBucket(String apiKey) {
        return bucketCache.computeIfAbsent(apiKey, this::newBucket);
    }

    private Bucket newBucket(String s) {
        return Bucket4j.builder()
                .addLimit(Bandwidth.classic(10, Refill.intervally(10, Duration.ofSeconds(1))))
                .build();
    }
}
