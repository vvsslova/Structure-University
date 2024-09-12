package com.github.vvsslova;

import com.github.vvsslova.exceptions.*;
import lombok.extern.slf4j.Slf4j;

/**
 * Здесь можно посмотреть на правильность работы всех методов
 * Для удобства добавлено логгирование
 */
@Slf4j
public class App {
    public static void main(String[] args) throws EmployeeAlreadyExistsException, EntityNotFoundException, StudentAlreadyExistsException, DepartmentAlreadyExistsException, FacultyAlreadyExistsException {
        University MSU = new University("MSU");
        log.info("Создали университет MSU");
        University.Faculty journalismFaculty = new University.Faculty("Faculty of Journalism");
        University.Faculty philologyFaculty = new University.Faculty("Faculty of Philology");
        log.info("Создали два факультета: журналистики и филологический");
        log.info("Добавим факультеты в структуру университета");
        MSU.addFaculty(journalismFaculty);
        MSU.addFaculty(philologyFaculty);
        MSU.removeFaculty(journalismFaculty);
        MSU.addFaculty(journalismFaculty);
        MSU.addFaculty(philologyFaculty);
        log.info("Теперь в университете есть два факультета: журналистики и филологический");
        University.Department internationalJournalismDepartment = new University.Department("Department of International Journalism");
        University.Department mediaCommunicationsDepartment = new University.Department("Department of Media Communications");
        University.Department russianLanguageDepartment = new University.Department("Department of Russian Language");
        University.Department russianLiteratureDepartment = new University.Department("Department of Russian Literature");
        log.info("Создано по две кафедры на каждый факультет");
        journalismFaculty.addDepartment(internationalJournalismDepartment);
        journalismFaculty.addDepartment(internationalJournalismDepartment);
        journalismFaculty.addDepartment(mediaCommunicationsDepartment);
        philologyFaculty.addDepartment(russianLanguageDepartment);
        philologyFaculty.addDepartment(russianLiteratureDepartment);
        philologyFaculty.removeDepartment(russianLanguageDepartment);
        philologyFaculty.addDepartment(russianLanguageDepartment);
        log.info("Создаем студентов и сотрудников и распределяем их по кафедрам");
        internationalJournalismDepartment.addStudent(new Student("Ivan", "Ivanov", 101));
        internationalJournalismDepartment.addStudent(new Student("Victoria", "Shilova", 201));
        mediaCommunicationsDepartment.addStudent(new Student("Alexander", "Butusov", 202));
        mediaCommunicationsDepartment.addStudent(new Student("Maria", "Proskurova", 203));
        russianLanguageDepartment.addStudent(new Student("Olesya", "Ivanova", 204));
        russianLanguageDepartment.addStudent(new Student("Michail", "Sidorov", 205));
        russianLiteratureDepartment.addStudent(new Student("Olga", "Trishina", 217));
        russianLiteratureDepartment.addStudent(new Student("Ksenia", "Smirnova", 205));
        russianLiteratureDepartment.removeStudent(new Student("Ksenia", "Smirnova", 205));
        russianLiteratureDepartment.addStudent(new Student("Ksenia", "Smirnova", 205));
        internationalJournalismDepartment.addEmployee(new Employee("Anna", "Danilova"));
        internationalJournalismDepartment.addEmployee(new Employee("Marina", "Remnyova"));
        mediaCommunicationsDepartment.addEmployee(new Employee("Andrey", "Ranchin"));
        mediaCommunicationsDepartment.addEmployee(new Employee("Sergey", "Alpatov"));
        russianLanguageDepartment.addEmployee(new Employee("Dmitry", "Ivinsky"));
        russianLanguageDepartment.addEmployee(new Employee("Alexey", "Lyapustin"));
        russianLanguageDepartment.removeEmployee(new Employee("Alexey", "Lyapustin"));
        russianLanguageDepartment.addEmployee(new Employee("Alexey", "Lyapustin"));
        russianLiteratureDepartment.addEmployee(new Employee("Natalya", "Romanova"));
        russianLiteratureDepartment.addEmployee(new Employee("Olga", "Baynova"));
        log.info("Теперь кафедры заполнены студентами и сотрудниками!");
        MSU.getFacultyList();
        journalismFaculty.getDepartmentList();
        russianLiteratureDepartment.getEmployeeList();
        mediaCommunicationsDepartment.getStudentList();
        russianLiteratureDepartment.getStudentList();
    }
}
