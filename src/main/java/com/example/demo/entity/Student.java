package com.example.demo.entity;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity
public class Student {


    @Id
    @Column(name = "student_id")

    @Positive(message = "musbet eded daxil edin")
    @NotNull(message = "eded daxil edin")
    private  Integer id;

    @NotBlank(message = "ad daxil edin")
    @Size(message = "adin uzunlugu 4 herfden az olmasin",min = 3)
    private  String name;


    private String surname;

    @ManyToMany()
    @JoinTable(name = "Students_Courses",
            joinColumns = @JoinColumn(name="student_id"),inverseJoinColumns = @JoinColumn(name="course_id")


    )
    public List<Course> courseList;




}
