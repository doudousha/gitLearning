package com.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;

import java.io.IOException;
import java.io.Reader;

/**
 * mybatis 测试基类
 * Created by Administrator on 2017/6/7.
 */
public class BaseTest {

    protected  static SqlSessionFactory sqlSessionFactory ;


    @BeforeClass
    public static void stepUp() throws IOException {

        String resource =  "mybatis-base.xml" ;
        Reader reader =  Resources.getResourceAsReader(resource) ;
        sqlSessionFactory =  new SqlSessionFactoryBuilder().build(reader) ;
    }
}
