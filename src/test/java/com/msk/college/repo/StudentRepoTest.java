package com.msk.college.repo;

import com.msk.college.domain.Student;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class StudentRepoTest {

    @Autowired
    private StudentRepo studentRepo;

    @Test
    public void saveOneStudent() {
        Student result = studentRepo.save(saveStudent("Mark"));
        assertThat(result.getName(), equalTo("Mark"));
    }

    @Test
    public void findAllStudents() {
        studentRepo.save(saveStudent("Kannan"));
        List<Student> students = new ArrayList<>();
        studentRepo.findAll().forEach(students::add);
        assertThat(students.size(), equalTo(1));
        assertThat(students.get(0).getName(), equalTo("Kannan"));
    }

    @Test
    public void findAllExpectedNoResults() {
        List<Student> students = new ArrayList<>();
        studentRepo.findAll().forEach(students::add);
        assertThat(students.size(), equalTo(0));
    }

    private Student saveStudent(String name) {
        Student student = new Student();
        student.setName(name);
        student.setSection("XII-A");
        student.setGender('M');
        return studentRepo.save(student);
    }
}
