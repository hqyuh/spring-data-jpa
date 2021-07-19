package com.example.springjpa.repository;

import com.example.springjpa.entity.Student;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByLastName(String lastName);

    List<Student> findByLastNameContaining(String name);

    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianName(String guardianName);

    Student findByFirstNameAndLastName(String firstName, String lastName);


    // JPQL có tham số ?1
    // @Query("select s from Student s where s.emailId = ?1")
    // Student getStudentByEmailAddress(String emailId);

    // Named Param
    @Query("select s from Student s where s.emailId = :status")
    Student getStudentByEmailAddress(@Param("status") String emailId);


    // JPQL
    @Query("select s.firstName from Student s where s.emailId = ?1")
    String getStudentFirstNameByEmailAddress(String emailId);


    // Native queries
    @Query(
            value = "SELECT * FROM tbl_student s WHERE s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailId);

    // findDistinct là tìm kiếm và loại bỏ đi các đối tượng trùng nhau
    List<Student> findDistinctPeopleByLastName(String lastName);

    // IgnoreCase là tìm kiếm không phân biệt hoa thường
    List<Student> findByLastNameAllIgnoreCase(String lastName);

    // List<Student> findAllByAgiBetween(int start, int end);

    // OrderBy là cách sắp xếp thứ tự trả về
    List<Student> findAllByOrderByLastNameAsc();


    @Modifying
    @Transactional
    @Query(
            value = "UPDATE tbl_student SET first_name = ?1 WHERE email_address = ?2",
            nativeQuery = true
    )
    int updateStudentNameByEmailId(String firstName, String emailId);



}
