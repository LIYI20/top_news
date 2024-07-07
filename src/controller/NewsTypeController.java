package controller;

import jakarta.servlet.annotation.WebServlet;
import service.NewsTypeService;
import service.impl.NewsTypeServiceImpl;

/**
 * ClassName: NewsTypeController
 * Package: controller
 * Description:
 *
 * @Author wbl
 * @Create 2024/7/3 19:02
 * @Version 1.0
 */
@WebServlet("/type/*")
public class NewsTypeController extends BaseController{
private NewsTypeService newsTypeService=new NewsTypeServiceImpl();


}
