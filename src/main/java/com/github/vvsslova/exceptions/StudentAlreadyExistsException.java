package com.github.vvsslova.exceptions;

/**
 * Этот класс создает исключение, выбрасываемое при попытке добавить уже существующего студента.
 */
public class StudentAlreadyExistsException extends Throwable {

    public StudentAlreadyExistsException(String message) {
        super(message);
    }

    /**
     * Метод возвращает сообщение, которое отображается при выбрасывании исключения.
     * @return Сообщение, которое будет отображаться в логе.
     */
    @Override
    public String getMessage() {
        return "Такой студент уже существует!";
    }
}
