package controller;

import command.CodeEnum;
import command.Response;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pojo.HeadlineDetailVo;
import pojo.HeadlineQueryVo;
import pojo.NewsType;
import service.NewsHeadlineService;
import service.NewsTypeService;
import service.impl.NewsHeadlineServiceImpl;
import service.impl.NewsTypeServiceImpl;
import util.WebUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: Protal
 * Package: controller
 * Description:
 *
 * @Author wbl
 * @Create 2024/7/6 10:28
 * @Version 1.0
 */
@WebServlet("/portal/*")
public class ProtalController extends BaseController{
private NewsHeadlineService newsHeadlineService=new NewsHeadlineServiceImpl();
private NewsTypeService newsTypeService=new NewsTypeServiceImpl();

protected void findAllTypes(HttpServletRequest req, HttpServletResponse resp){
    List<NewsType> types=newsTypeService.findAll();
    WebUtil.writeJson(resp,Response.build(CodeEnum.SUCCESS,types));
}

protected void findNewsPage(HttpServletRequest req,HttpServletResponse resp){
    HeadlineQueryVo headlineQueryVo=WebUtil.readJson(req,HeadlineQueryVo.class);
    Map<String,Object> pageInfo=newsHeadlineService.findNewsPage(headlineQueryVo);
    Map<String,Object>data=new HashMap<>();
    data.put("pageInfo",pageInfo);
    WebUtil.writeJson(resp,Response.build(CodeEnum.SUCCESS,data));
}

protected void showHeadlineDetail(HttpServletRequest req, HttpServletResponse resp){
    int hid=Integer.parseInt(req.getParameter("hid"));
    HeadlineDetailVo headlineDetailVo=newsHeadlineService.findHeadlineDetail(hid);
    Map<String,Object>data=new HashMap<>();
    data.put("headline",headlineDetailVo);
    Response response=Response.build(CodeEnum.SUCCESS,data);
    WebUtil.writeJson(resp,response);
}

}
