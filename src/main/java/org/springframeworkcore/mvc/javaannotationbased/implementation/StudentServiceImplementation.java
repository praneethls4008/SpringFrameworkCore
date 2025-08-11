package org.springframeworkcore.mvc.javaannotationbased.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframeworkcore.mvc.javaannotationbased.dao.StudentRepository;
import org.springframeworkcore.mvc.javaannotationbased.model.Student;
import org.springframeworkcore.mvc.javaannotationbased.service.StudentService;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class StudentServiceImplementation implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImplementation(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findByUsername(String username) {
        return studentRepository.findByUsername(username);
    }

}
