package ru.yandex.test_task.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.time.LocalTime;

/**
 * Общий тип для временных промежутков
 */
@Entity
@Setter
@Getter
@Builder
public class TimeDesignation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;

    private LocalTime from, to;
    public TimeDesignation(String timeInterval) {
        String[] allParts = timeInterval.split("-");
        this.from = LocalTime.parse(allParts[0]);
        this.to = LocalTime.parse(allParts[1]);
    }

    @Override
    public String toString() {
        return from + "-" + to;
    }

    public TimeDesignation() {}
}
