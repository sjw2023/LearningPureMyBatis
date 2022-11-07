package com.example.demo;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class AcquiringSqlSession {
    //Creating SqlSessionFactory from XML file
    String resource = "org/mybatis/example/mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory =
            new SqlSessionFactoryBuilder().build(inputStream);

    //Acqure a SqlSession
    try (SqlSession session = sqlSessionFactory.openSession()) {
        Blog blog = session.selectOne(
                "com.exmple.demo.mybatisMapper.selectMapper", 101);
    }
    //Acquire Mapper Instance
    try (SqlSession session = sqlSessionFactory.openSession()) {
        BlogMapper mapper = session.getMapper(BlogMapper.class);
        Blog blog = mapper.selectBlog(101);
    }
}
