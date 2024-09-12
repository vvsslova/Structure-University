package com.github.vvsslova;

import lombok.Data;

/**
 * Данный класс является макетом для создания студентов.
 */
@Data
public class Student {
    private final String name;
    private final String surname;
    private final int group;

    public Student(String name, String surname, int group) {
        this.name = name;
        this.surname = surname;
        this.group = group;
    }
}
