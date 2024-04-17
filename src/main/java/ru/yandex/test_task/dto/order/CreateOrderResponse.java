package ru.yandex.test_task.dto.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CreateOrderResponse {
    List<OrderDto> orders;
}
