package ru.yandex.test_task.dto.courier;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@AllArgsConstructor
public class GetCouriersResponse {
    @Valid
    List<CourierDto> couriers;
}
