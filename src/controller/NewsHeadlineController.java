package controller;

import command.CodeEnum;
import command.Response;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pojo.NewsHeadline;
import service.NewsHeadlineService;
import service.impl.NewsHeadlineServiceImpl;
import util.JwtHelper;
import util.WebUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: NewHeadlineController
 * Package: controller
 * Description:
 *
 * @Author wbl
 * @Create 2024/7/3 19:00
 * @Version 1.0
 */
@WebServlet("/headline/*")
public class NewsHeadlineController extends BaseController{
    private NewsHeadlineService newsHeadlineService=new NewsHeadlineServiceImpl();
    protected void publish(HttpServletRequest req, HttpServletResponse resp){
        NewsHeadline newsHeadline= WebUtil.readJson(req,NewsHeadline.class);
        String token=req.getHeader("token");
        Long userId= JwtHelper.getUserId(token);
        newsHeadline.setPublisher(userId.intValue());
        newsHeadlineService.addNewsheadline(newsHeadline);
       //因为已经设定了loginFilter,所以失败的情景已经在Filter中实现了
        WebUtil.writeJson(resp, Response.build(CodeEnum.SUCCESS,null));
    }

    protected void findHeadlineByHid(HttpServletRequest req,HttpServletResponse resp){
        int hid=Integer.parseInt(req.getParameter("hid"));
        NewsHeadline newsHeadline=newsHeadlineService.findHeadlineByHid(hid);
        Map<String,Object>map=new HashMap<>();
        map.put("headline",newsHeadline);
        WebUtil.writeJson(resp,Response.build(CodeEnum.SUCCESS,map));
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp){
        NewsHeadline newsHeadline=WebUtil.readJson(req,NewsHeadline.class);
        newsHeadlineService.update(newsHeadline);
        WebUtil.writeJson(resp,Response.build(CodeEnum.SUCCESS,null));
    }

    public void removeByHid(HttpServletRequest req,HttpServletResponse resp){
        int hid=Integer.parseInt(req.getParameter("hid"));
        newsHeadlineService.removeByHid(hid);
        WebUtil.writeJson(resp,Response.build(CodeEnum.SUCCESS,null));
    }
}
