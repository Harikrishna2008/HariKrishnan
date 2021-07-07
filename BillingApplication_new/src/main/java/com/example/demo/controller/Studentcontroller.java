package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.Studentservice;

@RequestMapping("/api/v1")
@RestController
public class Studentcontroller {

        private Studentservice studentService;

        public Studentcontroller(Studentservice studentService) {
                System.out.println("Hey i got an Student Service object");
                this.studentService = studentService;
        }

        @PostMapping("/student")
        public String createStudent(@RequestBody Student student) {
        	    System.out.println("CreateStudent");
                return studentService.addStudent(student); 
        }

        @GetMapping("/student")
        public List<Student> getAllStudents(){
        	System.out.println("getAllStudents");
                return studentService.getAllStudents();
        }

        @GetMapping("/student/{RollNumber}")
        public Student getStudentByRollNumber(@PathVariable("RollNumber") int RollNumber){
        	System.out.println("getStudentByRollNumber");
                return studentService.getStudent(RollNumber);
        }

        @PutMapping("/student")
        public String updateStudent(@RequestBody Student student){
        	System.out.println("updateStudent");
                return studentService.updateStudent(student);
        }

        @DeleteMapping("/student/{RollNumber}")
        public String deleteRollNumber(@PathVariable("RollNumber") int RollNumber){
        	System.out.println("deleteStudent");
                return studentService.deleteStudent(RollNumber);
        }

}