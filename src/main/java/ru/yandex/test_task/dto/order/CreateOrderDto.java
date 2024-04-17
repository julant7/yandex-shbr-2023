package ru.yandex.test_task.dto.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class CreateOrderDto {
    private Integer weight;
    BigDecimal price;
    private BigInteger district;
    @JsonProperty("delivery_time")
    private Set<String> deliveryTime;
}
