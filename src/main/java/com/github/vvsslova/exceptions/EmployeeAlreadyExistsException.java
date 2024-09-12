package com.github.vvsslova.exceptions;

/**
 * Этот класс описывает исключение, выбрасываемое при попытке добавить уже существующего сотрудника.
 */
public class EmployeeAlreadyExistsException extends Throwable{
    public EmployeeAlreadyExistsException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Cотрудник уже добавлен на кафедру!";
    }
}
