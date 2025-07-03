package com.example.Student.services;

import com.example.Student.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentServices {
    private List<Student> std = new ArrayList<>(
            Arrays.asList(new Student(1,"Manimegalai","CSE"),
                    new Student(2,"Varsha","ECE"),
                    new Student(3,"Tivya","AIML"))
    );
    public List<Student> getAllStudents(){
        return std;
    }
    public Student getStudentById(int id){
        return std.stream().filter(s->s.getRollno()==id).findFirst().orElse(null);
    }
    public void addStudents(Student student){
        std.add(student);
    }
    public void updateStudents(int id,Student student){
        for(int i=0;i<std.size();i++){
            Student s=std.get(i);
            if(s.getRollno()==id){
                std.set(i,student);
                return;
            }
        }
    }
    public void deleteStudents(int id) {
        Student st = std.stream().filter(s -> s.getRollno() == id).findFirst().orElse(null);
        if (st!=null) {
            std.remove(st);
        }else{
            System.out.println("Student not found with ID: " + id);
        }
    }

}
