package com.example.springjpa.repository;

import com.example.springjpa.entity.Course;
import com.example.springjpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository repo;


    @Test
    public void  saveTeacher(){

        Course course1 = Course.builder()
                .title("11")
                .credit(5)
                .build();

        Course course2 = Course.builder()
                .title("12")
                .credit(6)
                .build();

        Teacher teacher = Teacher
                .builder()
                .firstName("Quang")
                .lastName("Huy")
                // .courses(List.of(course1, course2))
                .build();

        repo.save(teacher);
    }

}