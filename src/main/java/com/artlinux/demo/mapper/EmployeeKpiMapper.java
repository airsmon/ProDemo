package com.artlinux.demo.mapper;

// import com.artlinux.demo.bean.Dept;
import com.artlinux.demo.bean.EmployeeKpi;
// import com.artlinux.demo.bean.SalaryData;

import java.util.List;
import java.util.Map;

public interface EmployeeKpiMapper {
    int deleteByPrimaryKey(String id);

    int insert(EmployeeKpi record);

    int insertSelective(EmployeeKpi record);

    EmployeeKpi selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(EmployeeKpi record);

    int updateByPrimaryKey(EmployeeKpi record);

    int selctByAll(Map<String, Object> map);

    List<EmployeeKpi> selctListByAll(Map<String, Object> map);

}