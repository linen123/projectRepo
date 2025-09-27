package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    
    @Autowired
    StudentRepo studentRepo;
    void saveStudentdetails(Student student){

        studentRepo.save(student);

    }

    Optional<Student> getStudentDetails(Long id){
       return studentRepo.findById(id);
    }
    
    
    
}
