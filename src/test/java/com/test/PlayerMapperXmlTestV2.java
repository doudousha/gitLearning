package com.test;

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
public class PlayerMapperXmlTestV2 extends BaseTest {

    private SqlSession sqlSession;
    private PlayerDao playerDao ;

    @Before
    public void before() {
        sqlSession = sqlSessionFactory.openSession(true);
         playerDao = sqlSession.getMapper(PlayerDao.class);
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
        Player player2 = playerDao.findById(2);
        System.out.println("player1: " + player1);

    }

    @Test
    public void testSave() {
        playerDao.save(new Player(-1,"xiao ming",29)) ;
    }

    @Test
    public void testUpdate() {

        playerDao.update(new Player(1,"c-r",30)) ;
    }

    @Test
    public void testDelete() {
        playerDao.delete(5) ;
    }

    @Test
    public  void testGetAll() {
     List<Player> list=   playerDao.getAll() ;
     for (Player player:list) {
         System.out.println(player);
     }
    }


}
