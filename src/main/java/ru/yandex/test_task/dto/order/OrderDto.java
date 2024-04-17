package ru.yandex.test_task.dto.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ru.yandex.test_task.dto.district.DistrictDto;
import ru.yandex.test_task.dto.time_designation.TimeDesignationDto;
import ru.yandex.test_task.entity.District;
import ru.yandex.test_task.entity.TimeDesignation;
import ru.yandex.test_task.entity.enums.TypeOfMovement;
import ru.yandex.test_task.utils.TimeValidation;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class OrderDto {
    @JsonProperty("id")
    private BigInteger id;

    private Integer weight;
    BigDecimal price;

    private DistrictDto district;

    @JsonProperty("delivery_time")
    private Set<TimeDesignationDto> deliveryTime;

}
