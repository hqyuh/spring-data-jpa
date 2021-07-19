package com.example.springjpa.repository;

import com.example.springjpa.entity.Course;
import com.example.springjpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repo;


    @Test
    public void saveCourseMaterial(){

        Course course =
                Course.builder()
                .title("ASK")
                .credit(100)
                .build();

        CourseMaterial courseMaterial =
                CourseMaterial.builder()
                .url("www.link.com")
                .course(course)
                .build();

        repo.save(courseMaterial);

    }

    @Test
    public void printAllCourseMaterials(){
        List<CourseMaterial> courseMaterials =
                repo.findAll();

        System.out.println("course = " + courseMaterials);
    }

}