package org.springframeworkcore.mvc.javaannotationbased.service;

import java.util.List;

import org.springframeworkcore.mvc.javaannotationbased.dto.request.teacher.TeacherCreateRequestDTO;
import org.springframeworkcore.mvc.javaannotationbased.dto.response.teacher.TeacherGetResponseDTO;
import org.springframeworkcore.mvc.javaannotationbased.model.Teacher;

public interface TeacherService{
    TeacherGetResponseDTO save(TeacherCreateRequestDTO Teacher) throws Exception;
    List<Teacher> getAllTeachers();
    TeacherGetResponseDTO findByUsername(String username) throws Exception;
}
