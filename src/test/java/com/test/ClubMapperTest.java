package com.test;

import com.dao.ClubDao;
import com.dao.PlayerDao;
import com.pojo.Club;
import com.pojo.Player;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/7.
 */
public class ClubMapperTest extends  BaseTest {
    private SqlSession sqlSession;
    private ClubDao clubDao ;

    @Before
    public void before() {
        sqlSession = sqlSessionFactory.openSession(true);
        clubDao = sqlSession.getMapper(ClubDao.class);
    }

    @After
    public void after() {

        if(sqlSession!=null)
        {
            sqlSession.close();
        }
    }

    @Test
    public  void testGetAll() {
        List<Club> list = clubDao.getAll();
        for (Club club : list) {
            System.out.println(club);
        }
    }

    @Test
    public void testGetByName() {
        List<Club> list = clubDao.getByName("AC");
        for (Club club : list) {
            System.out.println(club);
        }
    }


    @Test
    public void testUpdateRank() {
        testGetAll();
        clubDao.updateRank(2,3);
        System.out.println("after update rank...");
        testGetAll();
    }


    @Test
    public void testGetIds() {
        List<Integer> ids = new ArrayList<Integer>() ;
        ids.add(1);
        ids.add(3);

        List<Club> list = clubDao.getByIds(ids) ;
        for (Club club : list) {
            System.out.println(club);
        }
    }
}
