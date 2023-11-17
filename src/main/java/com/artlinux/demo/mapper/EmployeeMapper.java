package com.artlinux.demo.mapper;

import com.artlinux.demo.bean.Dept;
import com.artlinux.demo.bean.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {
    int deleteByPrimaryKey(String id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    int selctByAll(Map<String, Object> map);

    List<Dept> selctListByAll(Map<String, Object> map);
}