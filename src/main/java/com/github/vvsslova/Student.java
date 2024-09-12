package com.github.vvsslova;

import lombok.Data;

/**
 * @author vvsslova
 * Данный класс является макетом для создания студентов.
 */
@Data
public class Student {
    private final String name;
    private final String surname;
    private final int group;

    /**
     * Конструктор создает студента и инициализирует поля.
     * @param name Имя студента.
     * @param surname Фамилия студента.
     * @param group Учебная группа.
     */
    public Student(String name, String surname, int group) {
        this.name = name;
        this.surname = surname;
        this.group = group;
    }
}
