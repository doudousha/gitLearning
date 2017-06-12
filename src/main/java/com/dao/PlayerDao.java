package com.dao;

import com.pojo.Player;

import java.util.List;

/**
 * Created by Administrator on 2017/6/7.
 */
public interface PlayerDao {

    Player findById(int id) ;

    int save(Player player ) ;

    int update(Player  player);

    int delete(int id) ;

    List<Player> getAll();


}
