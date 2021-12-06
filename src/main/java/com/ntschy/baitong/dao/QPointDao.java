package com.ntschy.baitong.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface QPointDao {

    void updateImagePath(@Param("qid") String qid,
                         @Param("imgPath") String imgPath) throws RuntimeException;
}
