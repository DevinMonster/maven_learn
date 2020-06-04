package com.devin.dao.impl;

import com.devin.dao.StudentDAO;
import com.devin.entity.Student;
import com.devin.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    public List<Student> getStudents() {
        // 获取SqlSession对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        String sqlId = "com.devin.dao.StudentDAO.getStudents";

        List<Student> students = sqlSession.selectList(sqlId);

        sqlSession.close();
        return students;
    }

    public int insertStudent(Student student) {
// 获取SqlSession对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        String sqlId = "com.devin.dao.StudentDAO.insertStudent";

        int insert = sqlSession.insert(sqlId, student);
        sqlSession.commit();

        sqlSession.close();
        return insert;
    }
}
