package ru.yandex.test_task.dto.time_designation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ru.yandex.test_task.entity.TimeDesignation;

import java.time.LocalTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class TimeDesignationDto {
    @JsonProperty("time_interval")
    private String timeInterval;

    public TimeDesignation toTimeDesignation() {
        String[] allParts = timeInterval.split("-");
        return TimeDesignation.builder()
                .to(LocalTime.parse(allParts[0]))
                .from(LocalTime.parse(allParts[1]))
                .build();

    }

    public static TimeDesignationDto fromTimeDesignation(TimeDesignation timeDesignation) {
        return TimeDesignationDto.builder()
                .timeInterval(timeDesignation.getFrom() + "-" + timeDesignation.getTo())
                .build();
    }
}
