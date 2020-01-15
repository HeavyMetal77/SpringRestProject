package ua.tarastom.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
        if (studentId < 0 || studentId >= theStudents.size()) {
            throw new StudentNotFoundException("Student id is not found " + studentId);
        }
        return theStudents.get(studentId);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException studentNFE) {
        StudentErrorResponse studentErrorResponse = new StudentErrorResponse();

        studentErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        studentErrorResponse.setMessage(studentNFE.getMessage());
        studentErrorResponse.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(studentErrorResponse, HttpStatus.NOT_FOUND);
    }

    //для любых других исключений - ошибка 400
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception theAnyException) {
        StudentErrorResponse studentErrorResponse = new StudentErrorResponse();

        studentErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        studentErrorResponse.setMessage(theAnyException.getMessage());
        studentErrorResponse.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(studentErrorResponse, HttpStatus.BAD_REQUEST);
    }
}
