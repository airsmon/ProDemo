package com.artlinux.demo.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登陆验证的过滤器
 */

@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        // 1.判断Session中是否有user （LoginServlet登录中查询出来存储在Session域中的用户信息）

        System.out.println("111");

        HttpServletRequest req = (HttpServletRequest) request;
        // 注意：Session中的调用getSession()方法的request是HttpServletRequest包下的request所以需要把
        // Filter包下的request转换成HttpServletRequest包下的request
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");

        // 判断user是否为null
        if (user != null) {
            // 不为null，说明用户登录过了
            // 放行
            chain.doFilter(request, response);
        } else {
            // 为null，说明用户未登录 （跳转到登录页面）
            request.setAttribute("login_msg", "您尚未登陆！");
            request.getRequestDispatcher("/login.jsp").forward(req, response);
        }
    }

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }
}