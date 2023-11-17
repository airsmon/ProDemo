package com.artlinux.demo.controller;

import com.artlinux.demo.Util.PageModel;
import com.artlinux.demo.Util.Result;
// import com.artlinux.demo.bean.Dept;
import com.artlinux.demo.bean.EmployeeKpi;
import com.artlinux.demo.bean.SalaryData;
// import com.artlinux.demo.mapper.DeptMapper;
import com.artlinux.demo.mapper.EmployeeKpiMapper;
import com.artlinux.demo.mapper.SalaryDataMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
// import java.util.function.DoubleBinaryOperator;

//以下所有接口返回值均为json
@RestController()
public class EmployeeKpiController {

    @Autowired
    EmployeeKpiMapper employeeKpiMapper;

    // 模糊查询接口
    @GetMapping("/employeeKpi/show")
    public Result showUserCollect(PageModel pageModel, @RequestParam Map<String, Object> map) {

        int num = employeeKpiMapper.selctByAll(map);

        if (num == 0) {
            return Result.fail("未查询到数据");
        }

        PageModel pageModel1 = new PageModel(pageModel.getCurrentPage(), pageModel.getStepSize(), num);

        map.put("queryNumber", pageModel1.getQueryNumber());
        map.put("StepSize", pageModel1.getStepSize());

        List<EmployeeKpi> depts = employeeKpiMapper.selctListByAll(map);

        Map<String, Object> stringObjectMap = new HashMap<String, Object>();

        stringObjectMap.put("depts", depts);
        stringObjectMap.put("pageModel", pageModel1);

        return Result.succ("成功访问", stringObjectMap);

    }

    // 修改接口
    @GetMapping("/employeeKpi/updata")
    public Result deptUpdata(EmployeeKpi employeeKpi) {

        if (StringUtils.isBlank(employeeKpi.getId())) {
            return Result.fail("修改失败");
        }

        if (!StringUtils.isBlank(employeeKpi.getEmployeeid())) {
            return Result.fail("参数错误");
        }

        if (!StringUtils.isBlank(employeeKpi.getKpi())) {
            return Result.fail("参数错误");
        }

        int insert = employeeKpiMapper.updateByPrimaryKeySelective(employeeKpi);

        if (insert == 1) {
            return Result.succ("修改成功");
        }

        return Result.fail("修改失败");

    }

    @Autowired
    SalaryDataMapper salaryDataMapper;

    // 修改接口
    @GetMapping("/salaryData/show")
    public Result salaryData() {

        List<SalaryData> salaryDatas = salaryDataMapper.selectByAll();

        return Result.succ("查询成功", salaryDatas);

    }

    // 修改接口
    @GetMapping("/demo/shuzi")
    public Result shuzi(String num) {

        double shuzi = Integer.parseInt(num) * 4760 + 8480;

        return Result.succ("计算成功", shuzi);

    }

}