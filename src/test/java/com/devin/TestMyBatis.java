package com.devin;

import com.devin.dao.StudentDAO;
import com.devin.dao.impl.StudentDAOImpl;
import com.devin.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class TestMyBatis {
    /*
     *  用于测试:MyBatis配置
     * */
    @Test
    public void test0() {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null; // 加载mybatis主配值文件
        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            // 所有的CRUD都是使用sqlsession完成
            SqlSession sqlSession = sqlSessionFactory.openSession();

            final String sql = "com.devin.dao.StudentDAO." + "getStudents";
            List<Student> students = sqlSession.selectList(sql);
            for (Student student : students) {
                System.out.println("student = " + student);
            }

            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     *  用于测试:测试插入操作
     * */
    @Test
    public void test1() throws IOException {
        String resource = "mybatis-config.xml";
        // 加载mybatis主配值文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 所有的CRUD都是使用sqlsession完成
        SqlSession sqlSession = sqlSessionFactory.openSession();

        final String sql = "com.devin.dao.StudentDAO." + "insertStudent";
        Student student = new Student("89", "老表", "18240333", "男", 19, "软件技术", new Date());
        int numbs = sqlSession.insert(sql, student);
        // mybatis默认开启事务,要手动提交事务
        sqlSession.commit();

        System.out.println("numbs = " + numbs);
        sqlSession.close();

    }

    /*
     *  用于测试:查询学生数据
     * */
    @Test
    public void test2() {
        StudentDAO studentDAO = new StudentDAOImpl();
        for (Student student : studentDAO.getStudents()) {
            System.out.println("student = " + student);
        }
    }

    /*
     *  用于测试:插入对象
     * */
    @Test
    public void test3() {
        StudentDAO dao = new StudentDAOImpl();
        Student student = new Student("10", "傻狗",
                "18240758", "男", 18,
                "社会一", new Date());
        int i = dao.insertStudent(student);
        System.out.println("i = " + i);

    }
}
