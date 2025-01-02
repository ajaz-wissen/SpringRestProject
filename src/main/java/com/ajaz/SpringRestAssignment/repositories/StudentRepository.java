package com.ajaz.SpringRestAssignment.repositories;

import com.ajaz.SpringRestAssignment.entities.Student;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    long countByStandard(Integer standard);

    List<Student> findAllByPercentageGreaterThan(Integer percentage);

    List<Student> findAllByPercentageLessThan(Integer percentage);

    @Query(value = "from Student where school=?1 and standard=?2")
    List<Student> findAllCustom(String school, Integer standard);
}
