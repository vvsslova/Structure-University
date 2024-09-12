package com.github.vvsslova.exceptions;

/**
 * Этот класс описывает исключение, выбрасываемое при попытке удалить несуществующую сущность
 */
public class EntityNotFoundException extends Throwable {
    public EntityNotFoundException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Объект не найден!";
    }
}
