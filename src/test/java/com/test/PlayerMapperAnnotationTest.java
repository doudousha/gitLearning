package com.test;

import com.dao.PlayerAnnotationDao;
import com.dao.PlayerDao;
import com.pojo.Player;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/6/7.
 */
public class PlayerMapperAnnotationTest  extends BaseTest {



    private SqlSession sqlSession;
    private PlayerAnnotationDao playerAnnotationDao ;

    @Before
    public void before() {
        sqlSession = sqlSessionFactory.openSession(true);
        playerAnnotationDao = sqlSession.getMapper(PlayerAnnotationDao.class);
    }

    @After
    public void after() {

        if(sqlSession!=null)
        {
            sqlSession.close();
        }
    }

    @Test
    public void testGetPlayer() throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 1. statement
        String sqlStatement = "com.dao.PlayerDao" + ".findById";
        Player player1 = sqlSession.selectOne(sqlStatement, 1);
        System.out.println("player1: " + player1);


        // 2. proxy
        Player player2 = playerAnnotationDao.findById(2);
        System.out.println("player1: " + player1);

    }

    @Test
    public void testSave() {
        playerAnnotationDao.save(new Player(-1,"xiao ming",29)) ;
    }

    @Test
    public void testUpdate() {

        playerAnnotationDao.update(new Player(1,"c-r2",30)) ;
    }

    @Test
    public void testDelete() {
        playerAnnotationDao.delete(6) ;
    }

    @Test
    public  void testGetAll() {
        List<Player> list=   playerAnnotationDao.getAll() ;
        for (Player player:list) {
            System.out.println(player);
        }
    }



}
