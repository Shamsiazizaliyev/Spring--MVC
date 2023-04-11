package com.example.demo.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Data
public class Course {



    @Id
    @Column(name = "course_id")
    private  Integer id;

    private String name;

    private String description;



}
