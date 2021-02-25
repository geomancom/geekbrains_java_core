package Dz_9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<Course> course = new ArrayList();
        Course setCourse = new Course("Java. Уровень 1");
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student("Иванов", course = new ArrayList<>(Arrays.asList(
                        new Course("Введение в тестирование"),
                        new Course("Введение в тестирование. Практикум")

                ))),
                new Student("Сидоров", course = new ArrayList<>(Arrays.asList(
                        new Course("Введение в тестирование"),
                        new Course("Введение в тестирование. Практикум"),
                        new Course("Linux. Рабочая станция")

                ))),
                new Student("Петров", course = new ArrayList<>(Arrays.asList(
                        new Course("Введение в тестирование"),
                        new Course("Введение в тестирование. Практикум"),
                        new Course("Linux. Рабочая станция"),
                        new Course("Тестирование веб-приложений")

                ))),
                new Student("Козлов", course = new ArrayList<>(Arrays.asList(
                        new Course("Введение в тестирование"),
                        new Course("Введение в тестирование. Практикум"),
                        new Course("Linux. Рабочая станция"),
                        new Course("Тестирование веб-приложений"),
                        new Course("Java. Уровень 1")
                ))),
                new Student("Баранов", course = new ArrayList<>(Arrays.asList(
                        new Course("Введение в тестирование"),
                        new Course("Введение в тестирование. Практикум"),
                        new Course("Linux. Рабочая станция"),
                        new Course("Тестирование веб-приложений"),
                        new Course("Java. Уровень 1"),
                        new Course("Java Core для тестировщиков")

                )))
        ));

        List<String> unique = uniqueCourses(students.stream());
        System.out.println("список уникальных курсов:");
        System.out.println(unique);

        List<String> mostEducated = mostWanted(students.stream());
        System.out.println("список из трех самых любознательных:");
        System.out.println(mostEducated);

        List<String> studCourses = studentCourses(students.stream(), setCourse);
        System.out.println("список студентов, которые посещают курс: "+setCourse.getName());
        System.out.println(studCourses);


    }

    static List<String> uniqueCourses(Stream<Student> students) {
        return students.map(Student::getAllCourses)
                .flatMap(List::stream)
                .map(Course::getName)
                .distinct()
                .collect(Collectors.toList());
    }

    static List<String> mostWanted(Stream<Student> students) {
        return students
                .sorted(Comparator.comparingInt(o -> o.getAllCourses().size() * -1))
                .limit(3)
                .map(Student::getName)
                .collect(Collectors.toList());
    }

    static List<String> studentCourses(Stream<Student> students, Course SetCourse) {
        return students.filter(student -> student.getAllCourses().stream().anyMatch(course -> course.name == SetCourse.name))
                .map(Student::getName)
                .collect(Collectors.toList());
    }


}
