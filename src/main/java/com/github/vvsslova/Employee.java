package com.github.vvsslova;

import lombok.Data;

/**
 * Данный класс является макетом для создания сотрудников.
 */
@Data
public class Employee {
    private final String name;
    private final String surname;

    public Employee(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}
