package com.spring.service;

import com.spring.domain.Student;

import java.util.List;

public interface IStudentService {

     List<Student> listAllStudent();

     void addOrUpdateStudent(Student student);

     Student findStudentById(Long id);

     void deleteStudentById(Long id);


}
