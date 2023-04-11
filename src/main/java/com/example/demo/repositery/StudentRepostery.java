package com.example.demo.repositery;

import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepostery extends JpaRepository<Student,Integer> {




    @Query(value = "select * from Student where name=?1 ",nativeQuery = true)
    List<Student> studentListName(String name);



}
