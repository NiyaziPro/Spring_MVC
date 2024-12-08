package com.spring.controller;

import com.spring.domain.Student;
import com.spring.exception.StudentNotFoundException;
import com.spring.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private IStudentService service;

    @GetMapping("/hi")  // http://localhost:8081/Spring_MVC/students/hi
    public ModelAndView sayHi() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("message", "Hello,");
        mav.addObject("messagebody", "I'm Spring Management");
        mav.setViewName("hi");
        return mav;
    }

    @GetMapping // // http://localhost:8081/Spring_MVC/students/
    public ModelAndView getStudents() {
        ModelAndView mav = new ModelAndView();
        List<Student> listStudent = service.listAllStudent();
        mav.addObject("students", listStudent);
        mav.setViewName("students");
        return mav;
    }

    @GetMapping("/form") // // http://localhost:8081/Spring_MVC/students/form
    public String sendForm(@ModelAttribute("student") Student student) {
        return "studentForm";
    }

    @PostMapping("/saveStudent") // http://localhost:8081/Spring_MVC/students/saveStudent
    public String addStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "studentForm";
        }
        service.addOrUpdateStudent(student);
        return "redirect:/students";
    }


    // http://localhost:8081/Spring_MVC/students/update?id=1
    @GetMapping("/update")
    public ModelAndView sendFormForUpdate(@RequestParam("id")Long id){
        Student foundStudent = service.findStudentById(id);
        ModelAndView mav = new ModelAndView();
        mav.addObject("student",foundStudent);
        mav.setViewName("studentForm");

        return mav;

    }
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id")Long id){
        service.deleteStudentById(id);
        return "redirect:/students";
    }

    @ExceptionHandler(StudentNotFoundException.class)
    public ModelAndView handlerException(Exception exception){
        ModelAndView mav = new ModelAndView();
        mav.addObject("message",exception.getMessage());
        mav.setViewName("notFound");
        return mav;
    }

}
