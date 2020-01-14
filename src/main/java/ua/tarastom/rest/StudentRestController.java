package ua.tarastom.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.tarastom.entity.Student;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @GetMapping("/students")
    public List<Student> getListStudents() {
        ArrayList<Student> students = new ArrayList<Student>();

        students.add(new Student("Mary", "Black"));
        students.add(new Student("Jack", "Dude"));
        students.add(new Student("Susan", "Oliver"));

        return students;
    }
}
