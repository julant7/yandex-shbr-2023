package ru.yandex.test_task.utils;


import io.github.bucket4j.Bucket;
import io.github.bucket4j.ConsumptionProbe;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.test_task.exception.TooManyRequestException;
import ru.yandex.test_task.service.RateLimiterService;

@RequiredArgsConstructor
@Aspect
@Component
public class RateLimiterAspect {
    private final RateLimiterService rateLimiterService;

    @Autowired
    public RateLimiterAspect(RateLimiterService rateLimiterService) {
        this.rateLimiterService = rateLimiterService;
    }

    @Pointcut("@annotation(rateLimited)")
    public void rateLimitedPointcut(RateLimited rateLimited) {}

    @Before("rateLimitedPointcut(rateLimited)")
    public void limitRate(RateLimited rateLimited) {
        int limit = rateLimited.value();
        long interval = rateLimited.interval();

        // Проверяем, может ли запрос быть выполнен
        Bucket bucket = rateLimiterService.resolveBucket();
        ConsumptionProbe probe = bucket.tryConsumeAndReturnRemaining(limit);
        if (!probe.isConsumed()) {
            // Если запрос запрещен из-за превышения лимита
            throw new TooManyRequestException("Too many requests");
        }
    }
}
