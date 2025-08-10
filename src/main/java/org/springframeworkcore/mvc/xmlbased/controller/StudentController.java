package org.springframeworkcore.mvc.xmlbased.controller;

import org.springframeworkcore.mvc.xmlbased.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/student")
public class StudentController {

    public static Map<String, String> studentsCredentials = new HashMap<>();

    @GetMapping("")
    public String studentLoginPage(){
        return "studentLoginPage";
    }

    @PostMapping("/auth")
    public String studentAuthPage(@ModelAttribute Student student){
        if(student==null || student.getUsername().isEmpty() || student.getPassword().isEmpty() || student.getPassword().length()<4 || !studentsCredentials.containsKey(student.getUsername()) || !studentsCredentials.get(student.getUsername()).equals(student.getPassword())){
            return "redirect:/student";
        }
        return "redirect:/student/?username="+student.getUsername();

    }

    @GetMapping("/")
    public ModelAndView studentDashBoardPage(@RequestParam("username") String username){
        return new ModelAndView("studentDashboardPage", "username", username);
    }

    @GetMapping("/register")
    public String studentRegisterPage(){
        return "studentRegisterPage";
    }

    @PostMapping("/newaccount")
    public String studentNewAccount(@ModelAttribute Student student){
        if(student==null || student.getUsername().isEmpty() || student.getPassword().isEmpty() || student.getPassword().length()<4 || studentsCredentials.containsKey(student.getUsername())){
            return "redirect:/student/register";
        }

        studentsCredentials.put(student.getUsername(), student.getPassword());

        return "studentLoginPage";
    }



}
