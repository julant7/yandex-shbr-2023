package ru.yandex.test_task.dto.district;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ru.yandex.test_task.entity.District;

import java.math.BigInteger;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class DistrictDto {
    private BigInteger id;
    public District toDistrict() {
        return District.builder()
                .id(id)
                .build();
    }

    public static DistrictDto fromDistrict(District district) {
        return DistrictDto.builder()
                .id(district.getId())
                .build();
    }
}
