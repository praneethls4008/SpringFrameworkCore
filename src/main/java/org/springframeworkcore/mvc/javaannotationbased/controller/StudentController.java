package org.springframeworkcore.mvc.javaannotationbased.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframeworkcore.mvc.javaannotationbased.dto.request.student.StudentCreateRequestDTO;
import org.springframeworkcore.mvc.javaannotationbased.implementation.StudentServiceImplementation;
import org.springframeworkcore.mvc.javaannotationbased.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframeworkcore.mvc.javaannotationbased.service.AuthService;
import org.springframeworkcore.mvc.javaannotationbased.service.StudentService;

@Controller
@RequestMapping(value = "/student")
public class StudentController {
    StudentService studentService;
    AuthService authService;

    @Autowired
    public StudentController(StudentService studentService, AuthService authService){
        this.studentService = studentService;
        this.authService = authService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        System.out.println(webDataBinder.toString());
    }

    @GetMapping("")
    public String studentLoginPage(Model model){

        if (!model.containsAttribute("studentCreateRequestDTO")) {
            // supply an empty form-backing object
            model.addAttribute("studentCreateRequestDTO",
                    new StudentCreateRequestDTO("", ""));
        }
        return "studentLoginPage";
    }

    @PostMapping("/auth")
    public String studentAuthPage(@Valid @ModelAttribute StudentCreateRequestDTO studentDTO, BindingResult bindingResult, Model model){


        if(bindingResult.hasErrors()){
//            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "studentLoginPage";
        }

        try{
            authService.studentLogin(studentDTO);
        }catch (Exception authException){
            model.addAttribute("loginError", authException.getMessage());
            authException.printStackTrace();
            return "studentLoginPage";
        }
        return "redirect:/student/?username="+studentDTO.username();

    }

    @GetMapping("/")
    public ModelAndView studentDashBoardPage(@RequestParam("username") String username){
        return new ModelAndView("studentDashboardPage", "username", username);
    }

    @GetMapping("/register")
    public String studentRegisterPage(Model model){
        if (!model.containsAttribute("studentCreateRequestDTO")) {
            model.addAttribute("studentCreateRequestDTO",
                    new StudentCreateRequestDTO("", ""));
        }
        return "studentRegisterPage";
    }

    @PostMapping("/newaccount")
    public String studentNewAccount(@Valid @ModelAttribute StudentCreateRequestDTO studentRequestDTO, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "studentRegisterPage";
        }
        try{
            studentService.save(studentRequestDTO);
        } catch (Exception e) {
            model.addAttribute("loginError", e.getMessage());
            e.printStackTrace();
            return "studentRegisterPage";
        }
        return "studentLoginPage";
    }



}
