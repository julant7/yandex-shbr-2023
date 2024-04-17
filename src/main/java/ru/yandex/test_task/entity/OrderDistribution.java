package ru.yandex.test_task.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import java.math.BigInteger;

/**
 * Таблица для распределения заказов, представлена в виде временного хранилища;
 * Предполагается, что метод для распределения вызывается в начале дня, поэтому при вызове все прошлые
 * данные очищаются.
 */
@Data
@Entity
@RedisHash(value = "order_distribution")
public class OrderDistribution {
    @Id
    private BigInteger id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Order order;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Courier courier;
}
