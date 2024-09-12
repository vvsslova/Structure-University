package com.github.vvsslova;

import com.github.vvsslova.exceptions.*;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Этот класс реализовывает структуру университета, которая представлена двумя вложенными классами:
 * Faculty и Department.
 * Созданные мною исключения вынесены в отдельную папку!
 */
@Getter
@Slf4j
public class University {
    private final String name;
    private final List<Faculty> facultyList;

    public University(String name) {
        this.name = name;
        this.facultyList = new LinkedList<>();
    }

    /**
     * Метод добавляет факультет в структуру университета.
     * @param faculty Факультет, который необходимо добавить.
     * @throws FacultyAlreadyExistsException Исключение, выбрасываемое, если такой факультет уже существует.
     */
    public void addFaculty(Faculty faculty) throws FacultyAlreadyExistsException {
        if (facultyList.contains(faculty)) {
            throw new FacultyAlreadyExistsException("Этот факультет уже существует в структуре университета!");

        } else {
            facultyList.add(faculty);
            log.info("Факультет {} добавлен в структуру университета", faculty.name);
        }
    }

    /**
     * Метод удаляет факультет из структуры университета.
     * @param faculty Факультет, который необходимо удалить.
     * @throws EntityNotFoundException Исключение, которое выбрасывается, если такого факультета не существует.
     */
    public void removeFaculty(Faculty faculty) throws EntityNotFoundException {
        if (facultyList.contains(faculty)) {
            facultyList.remove(faculty);
            log.info("Факультет {} удалён из структуры университета", faculty.name);
        } else throw new EntityNotFoundException("Этого факультета не существует в структуре университета!");
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
     */
    @Getter
    static class Faculty {
        private final String name;
        private final List<Department> departmentList;

        public Faculty(String name) {
            this.name = name;
            this.departmentList = new LinkedList<>();
        }

        /**
         * Метод добавляет кафедру в структуру факультета.
         *
         * @param department Кафедра, которую необходимо добавить
         * @throws DepartmentAlreadyExistsException Исключение, которое выбрасывается, если такая кафедра уже существует
         */
        public void addDepartment(Department department) throws DepartmentAlreadyExistsException {
            if (departmentList.contains(department)) {
                throw new DepartmentAlreadyExistsException("Эта кафедра существует на данном факультете!");
            } else {
                departmentList.add(department);
                log.info("Кафедра {} добавлена в список факультета", department.name);
            }
        }

        /**
         * Метод удаляет кафедру из структуры факультета.
         *
         * @param department Кафедра, которую необходимо удалить
         * @throws EntityNotFoundException Исключение, которое выбрасывается, если такой кафедры не существует
         */
        public void removeDepartment(Department department) throws EntityNotFoundException {
            if (departmentList.contains(department)) {
                departmentList.remove(department);
                log.info("Кафедра {} удалена из списка факультета", department.name);
            } else throw new EntityNotFoundException("Этой кафедры не существует на факультете!");
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
     */
    @Getter
    static class Department {
        private final String name;
        private final List<Employee> empolyeeList;
        private final List<Student> studentList;

        public Department(String name) {
            this.name = name;
            this.empolyeeList = new LinkedList<>();
            this.studentList = new LinkedList<>();
        }

        /**
         * Метод добавляет студента в структуру кафедры
         *
         * @param student Студент, которого необходимо добавить
         * @throws StudentAlreadyExistsException Исключение, которое выбрасывается, если такой студент уже существует
         */
        public void addStudent(Student student) throws StudentAlreadyExistsException {
            if (studentList.contains(student)) {
                throw new StudentAlreadyExistsException("Этот студент уже существует на кафедре!");
            } else {
                studentList.add(student);
                log.info("Студент {} {} добавлен в список студентов кафедры", student.getName(), student.getSurname());
            }
        }

        /**
         * Метод добавляет сотрудника в структуру кафедры
         *
         * @param employee Сотрудник, которого необходимо добавить
         * @throws EmployeeAlreadyExistsException Исключение, выбрасываемое, если такой сотрудник уже существует
         */
        public void addEmployee(Employee employee) throws EmployeeAlreadyExistsException {
            if (empolyeeList.contains(employee)) {
                throw new EmployeeAlreadyExistsException("Этот сотрудник уже существует на кафедре!");
            } else {
                empolyeeList.add(employee);
                log.info("Сотрудник {} {} добавлен в список сотрудников кафедры", employee.getName(), employee.getSurname());
            }
        }

        /**
         * Метод удаляет студента из структуры кафедры.
         *
         * @param student Студент, которого надо удалить.
         * @throws EntityNotFoundException Исключение, выбрасываемое, если такой студент отсутствует
         */
        public void removeStudent(Student student) throws EntityNotFoundException {
            if (studentList.contains(student)) {
                studentList.remove(student);
                log.info("Студент {} {} удалён из списка студентов кафедры", student.getName(), student.getSurname());
            } else throw new EntityNotFoundException("Данного студента не существует на этой кафедре!");
        }

        /**
         * Метод удаляет сотрудника из структуры кафедры.
         *
         * @param employee Сотрудник, которого надо удалить.
         * @throws EntityNotFoundException Исключение, выбрасываемое, если такой сотрудник отсутсвует
         */
        public void removeEmployee(Employee employee) throws EntityNotFoundException {
            if (empolyeeList.contains(employee)) {
                empolyeeList.remove(employee);
                log.info("Сотрудник {} {} удалён из списка сотрудников кафедры", employee.getName(), employee.getSurname());
            } else throw new EntityNotFoundException("Данного сотрудника не существует на кафедре!");
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