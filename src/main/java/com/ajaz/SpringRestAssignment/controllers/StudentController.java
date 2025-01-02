package com.ajaz.SpringRestAssignment.controllers;

import com.ajaz.SpringRestAssignment.StudentService;
import com.ajaz.SpringRestAssignment.entities.Student;
import com.ajaz.SpringRestAssignment.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/strength")
    public Long getStudentsStrengthByStandard(Integer standard){
        return studentService.getStudentsStrengthByStandard(standard);
    }

    @GetMapping("/result")
    public List<Student> getStudentsByPassStatus(Boolean pass){
        return studentService.getStudentsByPassStatus(pass);
    }

    @GetMapping("/{school}/{standard}")
    public List<Student> getStudentsBySchoolAndStandard(@PathVariable("school") String school, @PathVariable("standard") Integer standard){
        return studentService.getStudentsBySchoolAndStandard(school, standard);
    }


}
