package com.artlinux.demo.controller;

import com.artlinux.demo.Util.Result;
import com.artlinux.demo.bean.Dept;
import com.artlinux.demo.mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//以下所有接口返回值均为json
@RestController()
public class DemoController {

    @Autowired
    private DeptMapper deptMapper;

    @GetMapping("/demo/login")
    // @PostMapping("/demo/login")
    public void login(HttpServletRequest request,
            HttpServletResponse response,
            // int remember)
            @RequestParam(name = "remember", defaultValue = "0") int remember)
            throws ServletException, IOException {
        // 1、接收客户端用户名和密码

        // System.out.println(request.getParameter("username"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 2、看是否登录成功
        Dept dept = deptMapper.selectByusernameAndpassword(username, password);

        // 3、判断查询是否有结果
        if (dept != null) {
            // 判断user不为null说明登录成功了
            System.out.println("登录成功");
            // 判断用户是否勾选了记住我 remember
            // 这里用："1".equals(remember) 而不用remember.equals("1")
            // 是为了防止空指针异常 因为remember有可能用户没勾选 为null 然后比较的话会空指针
            if ("1".equals(remember)) {
                // 勾选了,发送Cookie

                // 1 创建Cookie对象
                Cookie c_username = new Cookie("username", username);
                Cookie c_password = new Cookie("password", password);
                // 设置Cookie数据在客户端存活的时间
                c_username.setMaxAge(60 * 60 * 24 * 60);
                c_password.setMaxAge(60 * 60 * 24 * 60);
                // 2 发送Cookie
                response.addCookie(c_username);
                response.addCookie(c_password);

            }

            // 2. 把user查询出来的数据先封装到Session域当中 (数据保存在了服务器之间共享)
            HttpSession httpSession = request.getSession();
            // 存储到Session域中
            httpSession.setAttribute("dept", dept);

            // 1.登录成功 (要求：动态重定向到MVC三层架构讲的商品增删改查操作：SelectAllServlet资源下查询所有)
            String path = request.getContextPath();
            response.sendRedirect(path + "/selectAllServlet");

        } else {
            // 登录失败
            System.out.println("登录失败");
            // 储存错误提示信息到request域当中 转发给login.jsp
            request.setAttribute("login_msg", "用户名或密码错误");
            // 跳转到登录的login.jsp页面
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

    }

}
