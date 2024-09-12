package com.github.vvsslova;

import lombok.Data;

/**
 * @author vvsslova
 * Данный класс является макетом для создания сотрудников.
 */
@Data
public class Employee {
    private final String name;
    private final String surname;

    /**
     * Конструктор создает экземпляр сотрудника и инициализирует поля.
     * @param name Имя сотрудника.
     * @param surname Фамилия сотрудника.
     */
    public Employee(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}
