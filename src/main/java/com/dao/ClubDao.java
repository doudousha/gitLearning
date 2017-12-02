package com.dao;

import com.pojo.Club;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface  ClubDao {

    List<Club> getAll();

    List<Club> getByName(String name) ;

    void updateRank(@Param("id") int id , @Param("rank") int rank) ;

    List<Club> getByIds(@Param("ids") List<Integer> ids) ;

    /* 修复了bug */

}
