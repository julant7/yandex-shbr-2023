package ru.yandex.test_task.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CourierException extends RuntimeException {
    public CourierException(String message) {
        super(message);
    }
}
