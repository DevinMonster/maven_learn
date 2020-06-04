package com.devin.dao;

import com.devin.entity.Student;

import java.util.List;

public interface StudentDAO {
    // 操作tb_student表
    List<Student> getStudents();

    int insertStudent(Student student);

}
