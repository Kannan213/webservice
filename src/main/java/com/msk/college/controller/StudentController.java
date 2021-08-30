package com.msk.college.controller;

import com.msk.college.domain.Student;
import com.msk.college.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private StudentRepo studentRepo;

    @GetMapping("/students")
    public Iterable<Student> findAllStudents() {
        return studentRepo.findAll();
    }

    @GetMapping("/students/{id}")
    public Student findOneStudent(@PathVariable("id") long id) {
        return studentRepo.findById(id).orElse(null);
    }

    @PostMapping("/students/add")
    public Long addStudent(@RequestParam String name, @RequestParam String section, @RequestParam char gender) {
        Student student = new Student();
        student.setName(name);
        student.setSection(section);
        student.setGender(gender);
        return studentRepo.save(student).getId();
    }
}
