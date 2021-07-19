package com.example.springjpa.repository;

import com.example.springjpa.entity.Guardian;
import com.example.springjpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
// @DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository repo;

    @Test
    public void savaStudent(){
        Student student = Student.builder()
                .emailId("hoquang.huyy@gmail.com")
                .firstName("Hồ")
                .lastName("Quang Huy")
//                .guardianEmail("al@gmail.com")
//                .guardianName("AL")
//                .guardianMobile("9999999")
                .build();

        repo.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList
                = repo.findAll();

        System.out.println(studentList);
    }

    @Test
    public void saveStudentWithGuardian(){

        Guardian guardian = Guardian.builder()
                .email("gl@gmail.com")
                .name("GL")
                .mobile("9999999")
                .build();

        Student student = Student.builder()
                .firstName("James")
                .lastName("Cameron")
                .emailId("jame@gmail.com")
                .guardian(guardian)
                .build();

        repo.save(student);
    }


    @Test
    public void printStudentByFirstName(){
        List<Student> students =
                repo.findByLastNameContaining("Qu");

        System.out.println(students);
    }


    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students =
                repo.findByGuardianName("AL");

        System.out.println(students);
    }

    @Test
    public void printStudentFirstNameByEmailAddress(){
        String firstName =
                repo.getStudentFirstNameByEmailAddress("hoquang.huyy@gmail.com");

        System.out.println("name = " + firstName);
    }

    @Test
    public void printStudentByEmailAddress(){
        Student students =
                repo.getStudentByEmailAddressNative("hoquang.huyy@gmail.com");

        System.out.println(students);
    }

    @Test
    public void printFind(){
        List<Student> students =
                repo.findAllByOrderByLastNameAsc();

        System.out.println(students);
    }

    @Test
    public void updateStudentNameByEmailIdTest(){
        repo.updateStudentNameByEmailId(
                "HQ",
                "hoquang.huy@gmail.com");
    }

}