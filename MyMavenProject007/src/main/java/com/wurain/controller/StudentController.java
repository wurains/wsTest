package com.wurain.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wurain.model.Student;
import com.wurain.repository.StudentRepository;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/index")
    public ModelAndView index() {
        System.out.println("index...");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("student");
        modelAndView.addObject("list", studentRepository.findAll());

        return modelAndView;
    }

    @GetMapping("/findAll")
    @ResponseBody
    public Collection<Student> findAll() {
        return studentRepository.findAll();
    }

    @GetMapping("/findById/{id}")
    @ResponseBody
    public Student findById(@PathVariable("id") long id) {
        return studentRepository.findById(id);
    }

    @GetMapping("/save")
    @ResponseBody
    public void save(@RequestBody Student student) {
        studentRepository.saveOrUpdate(student);
    }

    @GetMapping("/update")
    @ResponseBody
    public void update(@RequestBody Student student) {
        studentRepository.saveOrUpdate(student);
    }

    @GetMapping("/deleteById/{id}")
    @ResponseBody
    public void deleteById(@PathVariable("id") long id) {
        studentRepository.deleteById(id);
    }
}
