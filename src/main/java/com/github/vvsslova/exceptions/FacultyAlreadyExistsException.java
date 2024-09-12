package com.github.vvsslova.exceptions;

/**
 * Этот класс описывает исключение, выбрасываемое при попытке добавить уже существующий факультет.
 */
public class FacultyAlreadyExistsException extends Throwable{
    public FacultyAlreadyExistsException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Такой факультет уже существует!";
    }
}
