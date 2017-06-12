package com.dao;

import com.pojo.Player;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by Administrator on 2017/6/7.
 */
public interface PlayerAnnotationDao {


    @Select("select id,name,age from  players where id=#{id}")
    Player findById(int id);


    @Insert("insert into players(name,age) values(#{name},#{age})")
    int save(Player player);


    @Update("update players set name=#{name} ,age=#{age} where id=#{id}")
    int update(Player player);

    @Delete("delete from players where id=#{id}")
    int delete(int id);

    @Select("select id,name,age from  players")
    List<Player> getAll();


}
