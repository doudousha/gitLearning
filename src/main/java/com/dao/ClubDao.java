package com.dao;

import com.pojo.Club;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/6/7.
 * 这是第二次修改
 */
public interface  ClubDao {

    List<Club> getAll();

    List<Club> getByName(String name) ;

    void updateRank(@Param("id") int id , @Param("rank") int rank) ;

    List<Club> getByIds(@Param("ids") List<Integer> ids) ;
}
