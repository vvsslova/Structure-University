package com.github.vvsslova.exceptions;

/**
 * Этот класс описывает исключение, выбрасываемое при попытке добавить уже существующую кафедру.
 */
public class DepartmentAlreadyExistsException extends Throwable {
    public DepartmentAlreadyExistsException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Эта кафедра существует на данном факультете!";
    }
}
