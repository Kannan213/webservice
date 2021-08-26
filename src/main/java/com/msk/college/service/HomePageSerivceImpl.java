package com.msk.college.service;

import com.msk.college.domain.Student;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class HomePageSerivceImpl implements HomePageService {
    @Override
    public List<Student> findAllStudents() {
        return Arrays.asList(
//                new Student(100, "Kannan", "XII-A", 'M')
        );
    }
}
