package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/student")
public class TestController {


    @Autowired
    StudentService studentService;

    @GetMapping("/test")
    public String testAPI(){

        return "Hello Service is Up & Running";
    }

    @PostMapping("/add/")
    public void addStudent(Student student){


        studentService.saveStudentdetails(student);





    }
    @GetMapping("/getDetails/{Id}")
    Student getStudentById(@PathVariable  Long Id){

         Optional<Student> student= studentService.getStudentDetails(Id);
         if(student.isPresent()){
             return  student.get();
         }
         else {
             return null;
         }

    }



}


