package ru.yandex.test_task.dto.courier;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
@AllArgsConstructor
public class GetCourierRatingResponse {
    BigInteger sum, rating;
}
