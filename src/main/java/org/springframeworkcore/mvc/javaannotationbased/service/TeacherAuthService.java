package org.springframeworkcore.mvc.javaannotationbased.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframeworkcore.mvc.javaannotationbased.dto.request.teacher.TeacherCreateRequestDTO;
import org.springframeworkcore.mvc.javaannotationbased.dto.request.teacher.TeacherLoginRequestDTO;
import org.springframeworkcore.mvc.javaannotationbased.dto.response.teacher.TeacherGetResponseDTO;
import org.springframeworkcore.mvc.javaannotationbased.model.Teacher;

@Service
public class TeacherAuthService {

    private final TeacherService teacherService;

    @Autowired
    public TeacherAuthService(TeacherService teacherService){
        this.teacherService = teacherService;
    }

    public void teacherLogin(TeacherLoginRequestDTO teacherLoginRequestDTO) throws Exception{
        if(teacherLoginRequestDTO==null){
            throw new Exception("teacher login credentials null!");
        }
        if(teacherLoginRequestDTO.username().isBlank()){
            throw new Exception("teacher login credentials username is empty!");
        }
        if(teacherLoginRequestDTO.password().isBlank()){
            throw new Exception("teacher login credentials password is empty!");
        }
        if(teacherLoginRequestDTO.username().length()<4){
            throw new Exception("teacher login credentials username is length should be greater than 3!");
        }
        if(teacherLoginRequestDTO.password().length()<4){
            throw new Exception("teacher login credentials password is length should be greater than 3!");
        }
        try{
            TeacherGetResponseDTO teacherDTOResponse = teacherService.findByUsername(teacherLoginRequestDTO.username());
            if(!teacherDTOResponse.password().equals(teacherLoginRequestDTO.password())){
                throw new Exception("teacher login credentials password is incorrect!");
            }
        }
        catch(Exception e){
            throw e;
        }
    }
}
