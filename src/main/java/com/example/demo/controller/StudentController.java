package com.example.demo.controller;


import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.repositery.CourseRepo;
import com.example.demo.repositery.StudentRepostery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/student")

public class StudentController {

    @Autowired
    private StudentRepostery  repostery;

    @Autowired
    private CourseRepo repo;






    @GetMapping("/index")


    public  String hello(Model model){



        return "index";
    }

    @GetMapping("/list")
    public  String getAllStudent(Model model){

       List<Student>list =repostery.findAll();


       model.addAttribute("students",list);

       return "list";
    }

    @GetMapping("/new")
    public  String newStudent(Model model){


        List<Course> courses = repo.findAll();
        model.addAttribute("student",new Student());
        model.addAttribute("courses",courses);

        return "detalis";
    }

    @PostMapping ("/save")
    public  String saveStudent(@Valid Student student, BindingResult  bindingResult,Model model){


         if(bindingResult.hasErrors()){
             return "detalis";
         }

        repostery.save(student);

        return "index";

    }
    @PostMapping ("/update")
    public  String updateStudent( Model model, Integer id){

        Optional<Student> student = repostery.findById(id);
        if(student.isPresent()){

            model.addAttribute("student",student);

            List<Course> courses = repo.findAll();

            model.addAttribute("courseAll",courses);
        }

        return "update";

    }
    @PostMapping ("/delete")
    public  String deleteStudent( Model model, Integer id){

        Optional<Student> student = repostery.findById(id);
        if(student.isPresent()){

            Student student1 = student.get();
            repostery.delete(student1);
        }

        return "index";

    }
}
