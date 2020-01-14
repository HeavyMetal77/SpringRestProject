package ua.tarastom.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.tarastom.entity.Student;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    @PostConstruct
    public void LoadData() {
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Mary", "Black"));
        theStudents.add(new Student("Jack", "Dude"));
        theStudents.add(new Student("Susan", "Oliver"));
    }


    @GetMapping("/students")
    public List<Student> getListStudents() {
        return theStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student getTheStudent(@PathVariable("studentId") int studentId) {
        return theStudents.get(studentId);
    }

}
