package ru.yandex.test_task.dto.order;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Setter;
import ru.yandex.test_task.dto.courier.CourierDto;
import ru.yandex.test_task.entity.Order;

import java.util.List;

@Setter
@AllArgsConstructor
public class GetOrdersResponse {
    @Valid
    List<OrderDto> couriers;
}
