package com.github.vvsslova.exceptions;

/**
 * Этот класс создает исключение, выбрасываемое при попытке добавить уже существующую кафедру.
 */
public class DepartmentAlreadyExistsException extends Throwable {
    public DepartmentAlreadyExistsException(String message) {
        super(message);
    }

    /**
     * Метод возвращает сообщение, которое отображается при выбрасывании исключения.
     * @return Сообщение, которое будет отображаться в логе.
     */
    @Override
    public String getMessage() {
        return "Эта кафедра существует на данном факультете!";
    }
}
