package com.artlinux.demo.mapper;

import com.artlinux.demo.bean.SalaryData;

import java.util.List;

public interface SalaryDataMapper {
    int deleteByPrimaryKey(Float salary);

    int insert(SalaryData record);

    int insertSelective(SalaryData record);

    SalaryData selectByPrimaryKey(Float salary);

    int updateByPrimaryKeySelective(SalaryData record);

    int updateByPrimaryKey(SalaryData record);

    List<SalaryData> selectByAll();
}