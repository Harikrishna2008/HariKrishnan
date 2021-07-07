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

import com.example.demo.model.Teachermodel;
import com.example.demo.service.Teacherservice;

@RequestMapping("/api/v1")
@RestController
public class Teachercontroller {

        private Teacherservice teacherService;

        public Teachercontroller(Teacherservice teacherService) {
                System.out.println("Hey i got an Teacher Service object");
                this.teacherService = teacherService;
        }

        @PostMapping("/Teacher")
        public String createTeacher(@RequestBody Teachermodel teacher) {
        	    System.out.println("CreateTeacher");
                return teacherService.addTeacher(teacher); 
        }

        @GetMapping("/Teacher")
        public List<Teachermodel> getAllTeachers(){
        	System.out.println("getAllTeachers");
                return teacherService.getAllTeachers();
        }

        @GetMapping("/Teacher/{RollNumber}")
        public Teachermodel getTeacherByRollNumber(@PathVariable("RollNumber") int RollNumber){
        	System.out.println("getTeacherByRollNumber");
                return teacherService.getTeacher(RollNumber);
        }

        @PutMapping("/Teacher")
        public String updateTeacher(@RequestBody Teachermodel teacher){
        	System.out.println("updateTeacher");
                return teacherService.updateTeacher(teacher);
        }

        @DeleteMapping("/Teacher/{RollNumber}")
        public String deleteRollNumber(@PathVariable("RollNumber") int RollNumber){
        	System.out.println("deleteTeacher");
                return teacherService.deleteTeacher(RollNumber);
        }

}