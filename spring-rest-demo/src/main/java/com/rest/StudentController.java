package com.rest;

import com.pojo.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    private List<Student> students;

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }
    @GetMapping("/students/{id}")
    public Student getStudents(@PathVariable int id) {
        return students.get(id);
    }

    @PostConstruct
    public void loadStudent()
    {
        students=new ArrayList<>();
        students.add(new Student(1,"rahul","rk"));
        students.add(new Student(2,"jay","kaxa"));
        students.add(new Student(3,"strretej","scientist"));
    }

}
