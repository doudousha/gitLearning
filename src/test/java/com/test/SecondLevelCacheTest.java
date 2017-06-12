package com.test;

import com.dao.PlayerDao;
import com.pojo.Player;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Administrator on 2017/6/8.
 */
public class SecondLevelCacheTest extends BaseTest {

    private SqlSession sqlSession1 ;
    private SqlSession sqlSession2 ;
    private SqlSession sqlSession3 ;
    private PlayerDao playerDao1;
    private PlayerDao playerDao2;
    private PlayerDao playerDao3;
    @Before
    public  void before() {
        sqlSession1 = sqlSessionFactory.openSession(false);
        sqlSession2 = sqlSessionFactory.openSession(false);
        sqlSession3 = sqlSessionFactory.openSession(false);


        playerDao1 = sqlSession1.getMapper(PlayerDao.class);
        playerDao2 = sqlSession2.getMapper(PlayerDao.class);
        playerDao3 = sqlSession3.getMapper(PlayerDao.class);
    }

    @After
    public void after() {
        sqlSession1.close();
        sqlSession2.close();
        sqlSession3.close();
    }



    @Test
    public void test1() {
        int id = 1 ;

        // sqlSession1 查询 ， 并提交到二级缓存
        PlayerDao  playerDao = sqlSession1.getMapper(PlayerDao.class) ;
       Player palyer1 =  playerDao.findById(id) ;
        sqlSession1.commit(); ;
        System.out.print("player1: " +palyer1);

        // sqlSession2 查询 ，修改并提交，清理二级缓存
        playerDao = sqlSession2.getMapper(PlayerDao.class) ;

        Player  player2 =   playerDao.findById(id) ;
        System.out.print("player2: " +player2);
        player2.setAge(20);
        playerDao.update(player2);
        sqlSession2.commit();

        // sqlSession3 查询，不命中
        playerDao =   sqlSession3.getMapper(PlayerDao.class) ;
        Player  player3 =   playerDao.findById(id) ;
        System.out.print("player3: " +player3);
    }

    /**
     * 测试 同时查询出对象one，和two ，当修改了one并且提交，two 也会被清理
     */

    @Test
    public void test2 () {

        int one= 1;
        int two  =2 ;


        // 查询并提交
        Player player1 = playerDao1.findById(one) ;
        playerDao1.findById((two)) ;
        System.out.print("player1: " +  player1);
        sqlSession1.commit();


        // session2 one命中后，更新并提交清空缓存

        Player  player2 =  playerDao2.findById(one);
        System.out.println("player2: " + player2);
        player2.setAge(15);
        playerDao2.update(player2);
        sqlSession2.commit();


        // session 查询two
        Player player3 = playerDao3.findById(two) ;
        System.out.println("player3: " + player3) ;


    }




}
