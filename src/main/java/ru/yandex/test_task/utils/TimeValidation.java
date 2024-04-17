package ru.yandex.test_task.utils;

public class TimeValidation {
    static public final String REGEXP = "\b(?:[01][0-9]|2[0-3]):[0-5][0-9]-(?:[01][0-9]|2[0-3]):[0-5][0-9]\b";
    static public final String ERROR_MESSAGE = "Время доставки должно задаваться в формате HH:MM-HH:MM.";
}
