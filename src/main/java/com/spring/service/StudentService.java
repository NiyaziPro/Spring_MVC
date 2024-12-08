package com.spring.service;


import com.spring.domain.Student;
import com.spring.exception.StudentNotFoundException;
import com.spring.repository.IStudentRepository;
import com.spring.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {

    @Autowired
    IStudentRepository studentRepository;

    public List<Student> listAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    //@Transactional
    public void addOrUpdateStudent(Student student) {
        studentRepository.saveOrUpdate(student);
    }

    @Override
    public Student findStudentById(Long id) {
        Student foundStudent = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not Found by ID : " + id));
        return foundStudent;
    }

    @Override
    public void deleteStudentById(Long id) {
        Student foundStudent = findStudentById(id);
        studentRepository.delete(foundStudent);
    }
}
