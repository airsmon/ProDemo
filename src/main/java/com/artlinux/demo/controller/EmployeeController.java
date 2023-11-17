package com.artlinux.demo.controller;

import com.artlinux.demo.Util.PageModel;
import com.artlinux.demo.Util.Result;
import com.artlinux.demo.bean.Dept;
import com.artlinux.demo.bean.Employee;
import com.artlinux.demo.mapper.EmployeeMapper;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//以下所有接口返回值均为json
@RestController()
public class EmployeeController {

    @Autowired
    EmployeeMapper employeeMapper;

    // 模糊查询接口
    @GetMapping("/employee/show")
    public Result employeeShow(PageModel pageModel, @RequestParam Map<String, Object> map) {

        int num = employeeMapper.selctByAll(map);

        if (num == 0) {
            return Result.fail("未查询到数据");
        }

        PageModel pageModel1 = new PageModel(pageModel.getCurrentPage(), pageModel.getStepSize(), num);

        map.put("queryNumber", pageModel1.getQueryNumber());
        map.put("StepSize", pageModel1.getStepSize());

        List<Dept> depts = employeeMapper.selctListByAll(map);

        Map<String, Object> stringObjectMap = new HashMap<String, Object>();

        stringObjectMap.put("depts", depts);
        stringObjectMap.put("pageModel", pageModel1);

        return Result.succ("成功访问", stringObjectMap);

    }

    // 修改接口
    @GetMapping("/employee/updata")
    public Result deptUpdata(Employee employee) {

        // 薪资不可修改
        if (!ObjectUtils.isEmpty(employee.getSalary())) {
            return Result.fail("薪资不可修改");
        }

        if (StringUtils.isBlank(employee.getId())) {
            return Result.fail("修改失败");
        }

        int insert = employeeMapper.updateByPrimaryKeySelective(employee);

        if (insert == 1) {
            return Result.succ("修改成功");
        }

        return Result.fail("修改失败");

    }

    // 增加接口
    @GetMapping("/employee/add")
    public Result employeeAdd(Employee employee) {

        // 判断参数
        if (StringUtils.isBlank(employee.getId()) || StringUtils.isBlank(employee.getDept())
                || StringUtils.isBlank(employee.getName()) || StringUtils.isBlank(employee.getPosition())) {
            return Result.fail("添加失败");
        }

        int insert = employeeMapper.insert(employee);

        if (insert == 1) {
            return Result.succ("添加成功");
        }

        return Result.fail("添加失败");

    }

    // 删除接口
    @GetMapping("/employee/del")
    public Result employeeDel(Employee employee) {

        if (StringUtils.isBlank(employee.getId())) {
            return Result.fail("删除失败");
        }

        int insert = employeeMapper.deleteByPrimaryKey(employee.getId());

        if (insert == 1) {
            return Result.succ("删除成功");
        }

        return Result.fail("删除失败");

    }

}
