package com.artlinux.demo;

// import com.artlinux.demo.bean.Dept;
import com.artlinux.demo.bean.SalaryData;
import com.artlinux.demo.mapper.DeptMapper;
import com.artlinux.demo.mapper.SalaryDataMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SqlTest {

    @Autowired(required = false)
    private DeptMapper deptMapper;

    @Autowired(required = false)
    private SalaryDataMapper salaryDataMapper;

    @Test
    void UserMapper8() {

        SalaryData salaryData = new SalaryData();

        salaryData.setYears(2023);
        salaryData.setSalary(3.14f);

        salaryDataMapper.insert(salaryData);

    }

}
