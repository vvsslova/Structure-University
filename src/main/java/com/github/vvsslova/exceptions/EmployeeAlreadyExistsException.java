package com.github.vvsslova.exceptions;

/**
 * Этот класс создает исключение, выбрасываемое при попытке добавить уже существующего сотрудника.
 */
public class EmployeeAlreadyExistsException extends Throwable{
    public EmployeeAlreadyExistsException(String message) {
        super(message);
    }

    /**
     * Метод возвращает сообщение, которое отображается при выбрасывании исключения.
     * @return Сообщение, которое будет отображаться в логе.
     */
    @Override
    public String getMessage() {
        return "Cотрудник уже добавлен на кафедру!";
    }
}
