package ru.yandex.test_task.service;

import io.github.bucket4j.Bucket;

public interface RateLimiterService {
    Bucket resolveBucket(String apiKey);
}
