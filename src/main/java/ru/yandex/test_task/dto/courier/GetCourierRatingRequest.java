package ru.yandex.test_task.dto.courier;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.yandex.test_task.utils.DateValidation;

@Getter
@Setter
@AllArgsConstructor
public class GetCourierRatingRequest {
    @JsonProperty("start_date")
    @Pattern(regexp = DateValidation.regexp, message = DateValidation.ERROR_MESSAGE)
    String startDate;

    @JsonProperty("end_date")
    @Pattern(regexp = DateValidation.regexp, message = DateValidation.ERROR_MESSAGE)
    String endDate;
}
