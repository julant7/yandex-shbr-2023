package ru.yandex.test_task.mapper;

import org.springframework.stereotype.Service;
import ru.yandex.test_task.dto.courier.CourierDto;
import ru.yandex.test_task.dto.courier.CreateCourierDto;
import ru.yandex.test_task.dto.district.DistrictDto;
import ru.yandex.test_task.dto.time_designation.TimeDesignationDto;
import ru.yandex.test_task.entity.Courier;

import java.util.stream.Collectors;

@Service
public class CourierMapper {

    public Courier toCourier(CourierDto courierDto) {
        return Courier.builder()
                .id(courierDto.getId())
                .typeOfMovement(courierDto.getTypeOfMovement())
                .districts(courierDto.getDistricts().stream()
                        .map(DistrictDto::toDistrict)
                        .collect(Collectors.toSet()))
                .timeDesignation(courierDto.getWorkSchedule().stream()
                        .map(TimeDesignationDto::toTimeDesignation)
                        .collect(Collectors.toSet()))
                .build();
    }

    public CourierDto toDto(Courier courier) {
        return CourierDto.builder()
                .id(courier.getId())
                .typeOfMovement(courier.getWorkSchedule())
                .districts(courier.getDistricts().stream()
                        .map(DistrictDto::fromDistrict)
                        .collect(Collectors.toSet()))
                .workSchedule(courier.getTimeDesignation().stream()
                        .map(TimeDesignationDto::fromTimeDesignation)
                        .collect(Collectors.toSet()))
                .build();
    }

    public CourierDto createCourierDtoToCourierDto(CreateCourierDto createCourierDto) {
        return CourierDto.builder()
                .typeOfMovement(createCourierDto.getTypeOfMovement())
                .districts(createCourierDto.getDistricts().stream()
                        .map(DistrictDto::new)
                        .collect(Collectors.toSet()))
                .workSchedule(createCourierDto.getWorkSchedule().stream()
                        .map(TimeDesignationDto::new)
                        .collect(Collectors.toSet()))
                .build();
    }

}
