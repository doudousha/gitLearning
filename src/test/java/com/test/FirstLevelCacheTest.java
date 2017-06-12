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
public class FirstLevelCacheTest extends BaseTest {

    private SqlSession sqlSession1 ;
    private SqlSession sqlSession2 ;

    @Before
    public  void before() {
        sqlSession1 = sqlSessionFactory.openSession(true);
        sqlSession2 = sqlSessionFactory.openSession(true);
    }

    @After
    public void after() {
        sqlSession1.close();
        sqlSession2.close();
    }


    /***
     * 测试一级缓存命中
     */
    @Test
    public void test1() {

        int id = 1 ;

        // 第一次查询，米有在sqlSession1 中命中，即再次查询数据库
        PlayerDao  playerDao =   sqlSession1.getMapper(PlayerDao.class) ;
        Player player =  playerDao.findById(id) ;

        System.out.println("player1: " + player);

        // 命中

        playerDao  = sqlSession1.getMapper(PlayerDao.class) ;
        player = playerDao.findById(id) ;
        System.out.println("palyer2: "  +player);

        // sqlSession1 和sqlSession2 在一级缓存的层面上没有任何关系

        playerDao = sqlSession2.getMapper(PlayerDao.class) ;
        player =  playerDao.findById(id) ;
        System.out.println("player3: " + player);


    }


    /**
     * 测试 sqlSession 对commit 会清除缓存
     */

    @Test
    public void test2() {

        int id = 1 ;

        // 第一次查询，米有在sqlSession1 中命中，即再次查询数据库
        PlayerDao  playerDao =   sqlSession1.getMapper(PlayerDao.class) ;
        Player player =  playerDao.findById(id) ;

        System.out.println("player1: " + player);

//        //1. session 提交
//        sqlSession1.commit();
        playerDao.save(new Player(-1,"xxxx",20)) ;

        playerDao  = sqlSession1.getMapper(PlayerDao.class) ;
        player = playerDao.findById(id) ;
        System.out.println("palyer2: "  +player);

    }

}
