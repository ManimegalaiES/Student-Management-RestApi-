package com.example.Student.controllers;

import com.example.Student.model.Student;
import com.example.Student.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentServices stu;

    @GetMapping("/")
    public String routes(){
        return "Welcome to spring boot security";
    }

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return stu.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable int id){
        return stu.getStudentById(id);
    }

    @PostMapping("/students")
    public void addStudents(@RequestBody Student student){
        stu.addStudents(student);
    }

    @PutMapping("/students/{id}")
    public void updateStudents(@PathVariable int id,@RequestBody Student student){
        stu.updateStudents(id,student);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable int id) {
        stu.deleteStudents(id);
    }
}
