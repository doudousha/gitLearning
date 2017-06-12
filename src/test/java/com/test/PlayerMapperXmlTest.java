package com.test;
import com.dao.PlayerDao;
import com.pojo.Player;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import  org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import org.apache.ibatis.io.Resources ;

/**
 * Created by Administrator on 2017/6/7.
 */
public class PlayerMapperXmlTest {


    @Test
    public void testGetPlayer() throws IOException {


        String resource =  "mybatis-base.xml" ;
        Reader reader =  Resources.getResourceAsReader(resource) ;
        SqlSessionFactory  sqlSessionFactory =  new SqlSessionFactoryBuilder().build(reader) ;

        SqlSession  sqlSession =  sqlSessionFactory.openSession(true);


        // 1. statement
        String sqlStatement =  "com.dao.PlayerDao" +".findById" ;
        Player  player1 =  sqlSession.selectOne(sqlStatement,1) ;

        System.out.println("player1: " + player1);


        // 2. proxy

        PlayerDao  playerDao = sqlSession.getMapper( PlayerDao.class) ;
        Player  player2=  playerDao.findById(2) ;
        System.out.println("player1: " + player1);


    }
}
