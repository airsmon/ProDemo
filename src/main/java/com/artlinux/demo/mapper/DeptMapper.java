package com.artlinux.demo.mapper;

import com.artlinux.demo.bean.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DeptMapper {
    int deleteByPrimaryKey(String id);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);

    Dept selectByusernameAndpassword(@Param("username") String username, @Param("password") String password);

    int selctByAll(Map<String, Object> map);

    List<Dept> selctListByAll(Map<String, Object> map);
}