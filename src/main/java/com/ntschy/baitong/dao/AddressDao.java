package com.ntschy.baitong.dao;

import com.ntschy.baitong.datasource.annotation.DataSource;
import com.ntschy.baitong.entity.DO.AddressRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AddressDao {

    @DataSource("slave1")
    List<AddressRecord> radar(@Param("minX") Double minX,
                              @Param("maxX") Double maxX,
                              @Param("minY") Double minY,
                              @Param("maxY") Double maxY) throws RuntimeException;
}
