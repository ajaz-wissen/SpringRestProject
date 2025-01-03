package com.ajaz.SpringRestAssignment.services;

import com.ajaz.SpringRestAssignment.entities.Student;
import com.ajaz.SpringRestAssignment.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Long getStudentsStrengthByStandard(Integer standard){
        System.out.println("standard: " + standard);
        return studentRepository.countByStandard(standard);
    }

    public List<Student> getStudentsByPassStatus(Boolean pass){
        System.out.println("pass: " + pass);
        if(pass) {
            return studentRepository.findAllByPercentageGreaterThan(40);
        }

        return studentRepository.findAllByPercentageLessThan(40);
    }

    public List<Student> getStudentsBySchoolAndStandard(@PathVariable("school") String school, @PathVariable("standard") Integer standard){
        return studentRepository.findAllCustom(school, standard);
    }


}
