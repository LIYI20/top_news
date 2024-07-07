package controller;

import command.CodeEnum;
import command.Response;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pojo.NewsUser;
import service.NewsUserService;
import service.impl.NewsUserServiceImpl;
import util.JwtHelper;
import util.MD5Util;
import util.WebUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: NewsUserController
 * Package: controller
 * Description:
 *
 * @Author wbl
 * @Create 2024/7/3 19:04
 * @Version 1.0
 */
@WebServlet("/user/*")
public class NewsUserController extends BaseController{
private NewsUserService newsUserService=new NewsUserServiceImpl();

protected void login(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {

    NewsUser LoginUser= WebUtil.readJson(req, NewsUser.class);
    NewsUser resUser=newsUserService.findByname(LoginUser.getUsername());
    Response response=null;
    if(resUser==null){
        response=Response.build(CodeEnum.USERNAME_ERROR,null);
    }
    else{
        if(resUser.getUserPwd().equals(MD5Util.encrypt(LoginUser.getUserPwd()))){
            //把uid当作token来响应给客户端
            String token= JwtHelper.createToken((long)resUser.getUid());
            Map<String,Object>data=new HashMap<>();
            data.put("token",token);
            response=Response.build(CodeEnum.SUCCESS,data);
        }
        else{
            response=Response.build(CodeEnum.USERPASSWORD_ERROR,null);
        }
        WebUtil.writeJson(resp,response);
    }
}

    protected void getUserInfo(HttpServletRequest req,HttpServletResponse resp){
    String token=req.getHeader("token");
    Response response=Response.build(CodeEnum.NOTLOGIN,"notLogin");
//        System.out.println(token);
        //判断token是否过期
    if(token!=null&&!JwtHelper.isExpiration(token)){
    int uid=JwtHelper.getUserId(token).intValue();
    NewsUser user=newsUserService.findByUid(uid);
    if(user!=null){
        //不返回密码
        user.setUserPwd("");
        Map<String,Object>data=new HashMap<>();
        data.put("loginUser",user);
        response=Response.build(CodeEnum.SUCCESS,data);
    }
    }
    WebUtil.writeJson(resp,response);

    }

    //检测同名
    protected void checkUserName(HttpServletRequest req,HttpServletResponse resp){
        String name=req.getParameter("username");
        Response response=Response.build(CodeEnum.SUCCESS,null);
        if(newsUserService.findByname(name)!=null){
            response=Response.build(CodeEnum.USERNAME_USED,null);
        }
    WebUtil.writeJson(resp,response);
    }

    protected void regist(HttpServletRequest req, HttpServletResponse resp) {
        NewsUser registerUser = WebUtil.readJson(req, NewsUser.class);
        System.out.println(registerUser);
        Response response = Response.build(CodeEnum.SERVER_ERROR, null);
        if(newsUserService.findByname(registerUser.getUsername())!=null){
            response=Response.build(CodeEnum.USERNAME_USED,null);
        }
        else if(newsUserService.register(registerUser)) {
            response = Response.build(CodeEnum.SUCCESS, null);
        }
        WebUtil.writeJson(resp, response);
    }

    //检测是否登录
    protected void checkLogin(HttpServletRequest req,HttpServletResponse resp){
    String token=req.getHeader("token");
    Response response=null;
    if(token!=null&&!JwtHelper.isExpiration(token)){
        response=Response.build(CodeEnum.SUCCESS,null);
    }
    else response=Response.build(CodeEnum.NOTLOGIN,null);
    WebUtil.writeJson(resp,response);
    }
}
