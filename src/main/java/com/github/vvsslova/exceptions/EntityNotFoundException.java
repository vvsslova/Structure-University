package com.github.vvsslova.exceptions;

/**
 * Этот класс создает исключение, выбрасываемое при попытке удалить несуществующую сущность
 */
public class EntityNotFoundException extends Throwable {
    public EntityNotFoundException(String message) {
        super(message);
    }

    /**
     * Метод возвращает сообщение, которое отображается при выбрасывании исключения.
     * @return Сообщение, которое будет отображаться в логе.
     */
    @Override
    public String getMessage() {
        return "Объект не найден!";
    }
}
