package com.devin.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtils {

    private static SqlSessionFactory factory = null;

    static {
        String config = "mybatis-config.xml"; // 配置文件
        try {
            InputStream inputStream = Resources.getResourceAsStream(config);
            // 创建sqlSessionFactory对象
            factory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   // 获取sqLSession
    public static SqlSession getSqlSession(boolean autocommit) {
        SqlSession sqlSession = null;
        if (factory != null) sqlSession = factory.openSession(autocommit);
        return sqlSession;
   }

    public static SqlSession getSqlSession() {
        SqlSession sqlSession = null;
        if (factory != null) sqlSession = factory.openSession();
        return sqlSession;
    }

}
