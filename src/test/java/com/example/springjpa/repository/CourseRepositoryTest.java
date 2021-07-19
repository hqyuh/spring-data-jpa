package com.example.springjpa.repository;

import com.example.springjpa.entity.Course;
import com.example.springjpa.entity.Student;
import com.example.springjpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository repo;

    @Test
    public void printCourses(){
        List<Course> courses =
                repo.findAll();

        System.out.println(courses);
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher
                .builder()
                .firstName("Hồ Quang")
                .lastName("Huy")
                .build();

        Course course = Course
                .builder()
                .title("Python")
                .credit(111)
                // .teacher(teacher)
                .build();

        repo.save(course);
    }


    @Test
    public void saveCourseWithStudentAndTeacher() {

        Student student1 = Student.builder()
                .firstName("Abhishek1")
                .lastName("Singh1")
                .emailId("abhishek@gmail.com11")
                .build();

        Course course1 = Course
                .builder()
                .title("AI1")
                .credit(121)
                .build();

        course1.addStudents(student1);

        Student student2 = Student.builder()
                .firstName("Abhishek2")
                .lastName("Singh2")
                .emailId("abhishek@gmail.com12")
                .build();

        Course course2 = Course
                .builder()
                .title("AI2")
                .credit(122)
                .build();

        course2.addStudents(student2);

        repo.save(course1);
        repo.save(course2);
    }

}