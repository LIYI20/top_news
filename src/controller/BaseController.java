package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * ClassName: BaseController
 * Package: controller
 * Description:
 *
 * @Author wbl
 * @Create 2024/7/3 18:42
 * @Version 1.0
 */
public class BaseController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=UTF-8");
        //uri是访问资源的路径,不会带参数和域名
        String uri=req.getRequestURI();
        String[] str=uri.split("/");
        String methodName=str[str.length-1];
        System.out.println(methodName);

        //通过反射获得所在的class，因为要调用该class中的mothod的方法
        //因为访问的时候我会到响应的类中执行该service，但是我们 不知道该类是什么，无法调用method
        Class clazz=this.getClass();
        try {
            Method method=clazz.getDeclaredMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
            method.setAccessible(true);
            method.invoke(this,req,resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
