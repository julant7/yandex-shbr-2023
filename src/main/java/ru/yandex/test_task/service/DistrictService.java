package ru.yandex.test_task.service;

import ru.yandex.test_task.entity.District;

import java.math.BigInteger;

public interface DistrictService {
    District getDistrictById(BigInteger id);
    District createDistrict(BigInteger id);
}
