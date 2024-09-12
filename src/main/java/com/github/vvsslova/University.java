package com.github.vvsslova;

import com.github.vvsslova.exceptions.*;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author vvsslova
 * Этот класс реализовывает структуру университета, которая представлена двумя вложенными классами:
 * Faculty и Depertment. Какждый из классов формирует структуру на своем уровне при помощи
 * методов добавления/удаления сущностей. Также предоставлена возможность по определенным критериям узнать,
 * какие именно сущности были добавлены в структуру на том или ином уровне.
 * Созданные мною исключения вынесены в отдельную папку!
 */
@Getter
@Slf4j
public class University {
    private final String name;
    List<Faculty> facultyList;

    /**
     * Конструктор создает университет и список факультетов для каждого экземпляра.
     * Под списком в методах ниже будет подразумеваться слово "структура".
     * @param name Название университета.
     */
    public University(String name) {
        this.name = name;
        this.facultyList = new LinkedList<>();
    }

    /**
     * Метод добавляет факультет в структуру университета.
     * Если добавляемый факультет уже есть, то вызывается исключение.
     * @param faculty Факультет, который необходимо добавить.
     */
    public void addFaculty(Faculty faculty) {
        if (facultyList.contains(faculty)) {
            try {
                throw new FacultyAlreadyExistsException("Этот факультет уже существует в структуре университета!");
            } catch (FacultyAlreadyExistsException e) {
                log.info(e.getMessage());
            }
        } else {
            facultyList.add(faculty);
            log.info("Факультет {} добавлен в структуру университета", faculty.name);
        }
    }

    /**
     * Метод удаляет факультет из структуры университета.
     * Если факультет отсуствует, то вызывается исключение.
     * @param faculty Факультет, который надо удалить.
     */
    public void removeFaculty(Faculty faculty) {
        if (facultyList.contains(faculty)) {
            facultyList.remove(faculty);
            log.info("Факультет {} удалён из структуры университета", faculty.name);
        } else try {
            throw new EntityNotFoundException("Этого факультета не существует в структуре университета!");
        } catch (EntityNotFoundException e) {
            log.info(e.getMessage());
        }
    }

    /**
     * Метод позволяет увидеть названия всех факультетов, добавленных в конкретный университет.
     */
    public void getFacultyList() {
        List<String> faculties = facultyList.stream()
                .map(Faculty::getName)
                .toList();
        log.info(Arrays.toString(faculties.toArray()));
    }

    /**
     * Данный класс реализует структуру университета на факультетском уровне.
     * Основные методы: добавление/удаление кафедр
     * и получение информации о названиях кафедр, существующих на факультете.
     */
    @Getter
    static class Faculty {
        private final String name;
        List<Department> departmentList;
        private Department department;

        /**
         * Конструктор создает факультет и список кафедр для каждого экземпляра.
         * Под списком в методах ниже будет подразумеваться слово "структура".
         * @param name Название факультета.
         */
        public Faculty(String name) {
            this.name = name;
            this.departmentList = new LinkedList<>();
        }

        /**
         * Метод добавляет кафедру в структуру факультета.
         * Если такая кафедра уже существует, то выбрасывается исключение.
         * @param department Кафедра, которую необходимо добавить.
         */
        public void addDepartment(Department department) {
            if (departmentList.contains(department)) {
                try {
                    throw new DepartmentAlreadyExistsException("Эта кафедра существует на данном факультете!");
                } catch (DepartmentAlreadyExistsException e) {
                    log.info(e.getMessage());
                }
            } else {
                departmentList.add(department);
                log.info("Кафедра {} добавлена в список факультета", department.name);
            }
        }

        /**
         * Метод удаляет кафедру из структуры факультета.
         * Если такая кафедра отсутствует, то выбрасывается исключение.
         * @param department Кафедра, которую необходимо удалить.
         */
        public void removeDepartment(Department department) {
            if (departmentList.contains(department)) {
                departmentList.remove(department);
                log.info("Кафедра {} удалена из списка факультета", department.name);
            } else try {
                throw new EntityNotFoundException("Этой кафедры не существует на факультете!");
            } catch (EntityNotFoundException e) {
                log.info(e.getMessage());
            }
        }

        /**
         * Метод позволяет получить список названий кафедр, добавленных на факультет.
         */
        public void getDepartmentList() {
            List<String> departmens = departmentList.stream()
                    .map(Department::getName)
                    .toList();
            log.info(Arrays.toString(departmens.toArray()));
        }
    }

    /**
     * Данный класс реализует структуру университета на уровне кафедры.
     * Основные методы: добавление/удаление сотрудников и студентов
     * и получение информации о фамилиях студентов и сотрудников.
     */
    @Getter
    static class Department {
        private final String name;
        List<Employee> empolyeeList;
        List<Student> studentList;
        private Student student;
        private Employee employee;

        /**
         * Конструктор создает кафедру и списки студентов и сотрудников для каждого экземпляра.
         * Под списком в методах ниже будет подразумеваться слово "структура".
         * @param name Название факультета.
         */
        public Department(String name) {
            this.name = name;
            this.empolyeeList = new LinkedList<>();
            this.studentList = new LinkedList<>();
        }

        /**
         * Метод добавляет студента в структуру кафедры.
         * Если такой студент уже есть, то выбрасывается исключение.
         * @param student Студент, которого надо добавить.
         */
        public void addStudent(Student student) {
            if (studentList.contains(student)) {
                try {
                    throw new StudentAlreadyExistsException("Этот студент уже существует на кафедре!");
                } catch (StudentAlreadyExistsException e) {
                    log.info(e.getMessage());
                }
            } else {
                studentList.add(student);
                log.info("Студент {} {} добавлен в список студентов кафедры", student.getName(), student.getSurname());
            }
        }

        /**
         * Метод добавляет сотрудника в структуру кафедры.
         * Если такой сотрудник уже есть, то выбрасывается исключение.
         * @param employee Сотрудник, которого надо добавить.
         */
        public void addEmployee(Employee employee) {
            if (empolyeeList.contains(employee)) {
                try {
                    throw new EmployeeAlreadyExistsException("Этот сотрудник уже существует на кафедре!");
                } catch (EmployeeAlreadyExistsException e) {
                    log.info(e.getMessage());
                }
            } else {
                empolyeeList.add(employee);
                log.info("Сотрудник {} {} добавлен в список сотрудников кафедры", employee.getName(), employee.getSurname());
            }
        }

        /**
         * Метод удаляет студента из структуры кафедры.
         * Если такой студент отсутствует, то выбрасывается исключение.
         * @param student Студент, которого надо удалить
         */
        public void removeStudent(Student student) {
            if (studentList.contains(student)) {
                studentList.remove(student);
                log.info("Студент {} {} удалён из списка студентов кафедры", student.getName(), student.getSurname());
            } else {
                try {
                    throw new EntityNotFoundException("Данного студента не существует на этой кафедре!");
                } catch (EntityNotFoundException e) {
                    log.info(e.getMessage());
                }
            }
        }

        /**
         * Метод удаляет сотрудника из структуры кафедры.
         * Если такой сотрудник отстутствует, то выбрасывается исключение.
         * @param employee Сотрудник, которого надо удалить
         */
        public void removeEmployee(Employee employee) {
            if (empolyeeList.contains(employee)) {
                empolyeeList.remove(employee);
                log.info("Сотрудник {} {} удалён из списка сотрудников кафедры", employee.getName(), employee.getSurname());
            } else try {
                throw new EntityNotFoundException("Данного сотрудника не существует на кафедре!");
            } catch (EntityNotFoundException e) {
                log.info(e.getMessage());
            }
        }

        /**
         * Метод позволяет узнать фамилии студентов, существующих на кафедре.
         */
        public void getStudentList() {
            List<String> students = studentList.stream()
                    .map(Student::getSurname)
                    .toList();
            log.info(Arrays.toString(students.toArray()));
        }

        /**
         * Метод позволяет узнать фамилии сотрудников кафедры.
         */
        public void getEmployeeList() {
            List<String> employees = empolyeeList.stream()
                    .map(Employee::getSurname)
                    .toList();
            log.info(Arrays.toString(employees.toArray()));
        }
    }
}