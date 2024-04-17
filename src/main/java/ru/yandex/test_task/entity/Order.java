package ru.yandex.test_task.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Set;

@Data
@Entity
@Builder
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;

    private Integer weight;
    BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private District district;

    @Column(name = "order_status")
    private OrderStatus orderStatus = OrderStatus.OPENED;

    @JoinColumn(name = "courier_id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Courier courier;

    @Column(name = "delivery_time")
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<TimeDesignation> deliveryTime;

    @Column(name = "completion_date")
    LocalDateTime completionDate;

    public Order() {

    }
}
