package com.github.vvsslova.exceptions;

/**
 * Этот класс описывает исключение, выбрасываемое при попытке добавить уже существующего студента.
 */
public class StudentAlreadyExistsException extends Throwable {

    public StudentAlreadyExistsException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Такой студент уже существует!";
    }
}
