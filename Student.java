package Dz_9;
import java.util.List;

public class Student {
    public String name;
    public List<Course> course;

    public Student(String name, List<Course> course) {
        this.name = name;
        this.course = course;
    }


    public String getName() {
        return name;
    }

    public List<Course> getAllCourses() {
        return course;
    }
}
