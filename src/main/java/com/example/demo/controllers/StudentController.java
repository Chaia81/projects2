package com.example.demo.controllers;

import com.example.demo.models.Student;
import com.example.demo.repositories.IStudentRepos;
import com.example.demo.repositories.InMemoryStudentReposImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {

    private IStudentRepos studentRepos;

    public StudentController(){
        studentRepos = new InMemoryStudentReposImpl();
    }

    @GetMapping("info")
    public String info(Model model){
        model.addAttribute("students" , studentRepos.readAll());
        return "student/info";
    }

}
