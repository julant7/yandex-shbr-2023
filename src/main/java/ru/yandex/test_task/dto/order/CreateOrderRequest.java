package ru.yandex.test_task.dto.order;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CreateOrderRequest {
    @Valid
    List<CreateOrderDto> orders;
}
