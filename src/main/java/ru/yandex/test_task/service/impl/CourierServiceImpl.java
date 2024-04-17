package ru.yandex.test_task.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yandex.test_task.dto.courier.*;
import ru.yandex.test_task.entity.Courier;
import ru.yandex.test_task.exception.CourierException;
import ru.yandex.test_task.mapper.CourierMapper;
import ru.yandex.test_task.repository.CourierRepository;
import ru.yandex.test_task.service.CourierService;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class CourierServiceImpl implements CourierService {
    private final CourierRepository courierRepository;
    private final CourierMapper courierMapper;

    @Value("${constants.walking.sum}")
    private int RATIO_SUM_WALKING;

    @Value("${constants.bicycle.sum}")
    private int RATIO_SUM_BICYCLE;

    @Value("${constants.car.sum}")
    private int RATIO_SUM_CAR;

    @Value("${constants.walking.rating}")
    private int RATIO_RATING_WALKING;

    @Value("${constants.bicycle.rating}")
    private int RATIO_RATING_BICYCLE;

    @Value("${constants.car.rating}")
    private int RATIO_RATING_CAR;

    @Override
    @Transactional
    public CreateCourierResponse createCouriers(CreateCourierRequest createCourierRequest) {
        List<CourierDto> courierDtos = createCourierRequest.getCouriers().stream()
                .map(courierMapper::createCourierDtoToCourierDto)
                .toList();

        List<Courier> couriers = courierDtos.stream()
                .map(courierMapper::toCourier)
                .toList();

        List<Courier> savedCouriers = courierRepository.saveAll(couriers);

        List<CourierDto> savedCourierDtos = savedCouriers.stream()
                .map(courierMapper::toDto)
                .toList();

        return new CreateCourierResponse(savedCourierDtos);

    }

    @Override
    public CourierDto getCourierById(BigInteger id) {
        Optional<Courier> courierOptional = courierRepository.findById(id);
        if (courierOptional.isPresent()) return courierMapper.toDto(courierOptional.get());
        throw new CourierException(String.format("Courier with id %s not found.", id));
    }

    @Override
    public GetCouriersResponse getCouriersWithRestrictions(BigInteger offset, BigInteger limit) {
        Optional<List<Courier>> courierOptional = courierRepository.findCouriersWithRestrictions(offset, limit);
        if (courierOptional.isPresent()) {
            List<CourierDto> savedCourierDtos = courierOptional.get().stream()
                    .map(courierMapper::toDto)
                    .toList();

            return new GetCouriersResponse(savedCourierDtos);
        }
        throw new CourierException("Restriction isn't correct");
    }

    @Override
    public GetCourierRatingResponse getCourierRating(String courier_id, GetCourierRatingRequest getCourierRatingRequest) {

        return null;
    }
}
