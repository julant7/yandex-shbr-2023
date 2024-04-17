package ru.yandex.test_task.dto.courier;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.yandex.test_task.dto.courier.CreateCourierDto;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
public class CreateCourierRequest {
    @Valid
    private List<CreateCourierDto> couriers;
}
