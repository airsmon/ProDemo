package com.artlinux.demo.controller;

import com.artlinux.demo.Util.PageModel;
import com.artlinux.demo.Util.Result;
import com.artlinux.demo.bean.Dept;
import com.artlinux.demo.mapper.DeptMapper;
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
public class DeptController {

    @Autowired
    DeptMapper deptMapper;

    // 模糊查询接口
    @GetMapping("/dept/show")
    public Result showUserCollect(PageModel pageModel, @RequestParam Map<String, Object> map) {

        String id = map.get("id") + "";
        String manager = map.get("manager") + "";
        String name = map.get("name") + "";
        System.out.println(name);

        int num = deptMapper.selctByAll(map);

        if (num == 0) {
            return Result.fail("未查询到数据");
        }

        PageModel pageModel1 = new PageModel(pageModel.getCurrentPage(), pageModel.getStepSize(), num);

        map.put("queryNumber", pageModel1.getQueryNumber());
        map.put("StepSize", pageModel1.getStepSize());

        List<Dept> depts = deptMapper.selctListByAll(map);

        Map<String, Object> stringObjectMap = new HashMap<String, Object>();

        stringObjectMap.put("depts", depts);
        stringObjectMap.put("pageModel", pageModel1);

        return Result.succ("成功访问", stringObjectMap);

    }

    // 修改接口
    @GetMapping("/dept/updata")
    public Result deptUpdata(Dept dept) {

        if (StringUtils.isBlank(dept.getId())) {
            return Result.fail("修改失败");
        }

        int insert = deptMapper.updateByPrimaryKeySelective(dept);

        if (insert == 1) {
            return Result.succ("修改成功");
        }

        return Result.fail("修改失败");

    }

    // 增加接口
    @GetMapping("/dept/add")
    public Result deptAdd(Dept dept) {

        if (StringUtils.isBlank(dept.getId()) || StringUtils.isBlank(dept.getManager())
                || StringUtils.isBlank(dept.getName())) {
            return Result.fail("添加失败");
        }

        int insert = deptMapper.insert(dept);

        if (insert == 1) {
            return Result.succ("添加成功");
        }

        return Result.fail("添加失败");

    }

    // 删除接口
    @GetMapping("/dept/del")
    public Result deptDel(Dept dept) {

        if (StringUtils.isBlank(dept.getId())) {
            return Result.fail("删除失败");
        }

        int insert = deptMapper.deleteByPrimaryKey(dept.getId());

        if (insert == 1) {
            return Result.succ("删除成功");
        }

        return Result.fail("删除失败");

    }

}
