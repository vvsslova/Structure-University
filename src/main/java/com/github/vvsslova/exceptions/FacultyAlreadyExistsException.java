package com.github.vvsslova.exceptions;

/**
 * Этот класс создает исключение, выбрасываемое при попытке добавить уже существующий факультет.
 */
public class FacultyAlreadyExistsException extends Throwable{
    public FacultyAlreadyExistsException(String message) {
        super(message);
    }

    /**
     * Метод возвращает сообщение, которое отображается при выбрасывании исключения.
     * @return Сообщение, которое будет отображаться в логе.
     */
    @Override
    public String getMessage() {
        return "Такой факультет уже существует!";
    }
}
