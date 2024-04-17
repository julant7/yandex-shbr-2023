package ru.yandex.test_task.entity.enums;

import com.fasterxml.jackson.annotation.JsonValue;


public enum TypeOfMovement {
    WALKING("WALKING"),
    BICYCLE("BICYCLE"),
    CAR("CAR");
    private final String value;
    TypeOfMovement(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue(){
        return value;
    }
}
