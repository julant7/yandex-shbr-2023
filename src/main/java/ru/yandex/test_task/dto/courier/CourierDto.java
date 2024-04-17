package ru.yandex.test_task.dto.courier;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ru.yandex.test_task.dto.district.DistrictDto;
import ru.yandex.test_task.dto.time_designation.TimeDesignationDto;
import ru.yandex.test_task.entity.enums.TypeOfMovement;
import ru.yandex.test_task.utils.TimeValidation;

import java.math.BigInteger;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class CourierDto {
    @JsonProperty("id")
    private BigInteger id;

    @JsonProperty("type_of_movement")
    private TypeOfMovement typeOfMovement;

    private Set<DistrictDto> districts;

    @JsonProperty("work_schedule")
    @Pattern(regexp = TimeValidation.REGEXP, message = TimeValidation.ERROR_MESSAGE)
    private Set<TimeDesignationDto> workSchedule;
}
