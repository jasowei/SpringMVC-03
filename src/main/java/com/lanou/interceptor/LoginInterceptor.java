package com.lanou.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by dllo on 17/11/10.
 */
public class LoginInterceptor implements HandlerInterceptor {


    /**
     * 在HandlerMapping寻找控制器之前会进入的方法
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        /*除了登录请求之外的其他任何请求都进入登录判断
        * 如果在session中存储过用户信息, 则默认没有登录过,跳转回登录界面
        * 反之, 放行*/

        String uri = request.getRequestURI();//获取请求路径
        if (uri.indexOf("login") != -1){//排除登录请求
            return true;//放行
        }

        //获取session对象
        HttpSession session = request.getSession();
        String uname = (String) session.getAttribute("uname");
        if (uname == null || "".equals(uname)){
            //没有登陆过, 回登录页面
            request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request,response);
        }

        return true;
    }

    /**
     * 当控制器执行结束之后会进入到方法, 即业务处理完毕,但视图还未返回前进入的方法
     */
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 当整个控制器方法完成之后, 即视图和数据都处理完毕之后会进入的方法
     */
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
