package ru.yandex.test_task.service;

import ru.yandex.test_task.dto.courier.*;
import ru.yandex.test_task.entity.Courier;

import java.math.BigInteger;
import java.util.List;

public interface CourierService {
    CreateCourierResponse createCouriers(CreateCourierRequest createCourierRequest);
    CourierDto getCourierById(BigInteger id);
    GetCouriersResponse getCouriersWithRestrictions(BigInteger offset, BigInteger limit);
    GetCourierRatingResponse getCourierRating(String courier_id, GetCourierRatingRequest getCourierRatingRequest);
//    getAssignmentOrders


}
