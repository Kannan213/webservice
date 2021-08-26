package com.msk.college.service;

import com.msk.college.domain.Student;

import java.util.List;

public interface HomePageService {
    List<Student> findAllStudents();
}
