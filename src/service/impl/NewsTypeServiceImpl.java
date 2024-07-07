package service.impl;

import dao.NewsTypeDao;
import dao.impl.NewsTypeDaoImpl;
import pojo.NewsType;
import service.NewsTypeService;

import java.util.List;

/**
 * ClassName: NewsTypeServiceImpl
 * Package: service.impl
 * Description:
 *
 * @Author wbl
 * @Create 2024/7/3 18:40
 * @Version 1.0
 */
public class NewsTypeServiceImpl implements NewsTypeService {
    private NewsTypeDao newsTypeDao=new NewsTypeDaoImpl();
    public List<NewsType> findAll(){
        return newsTypeDao.findAll();
    }
}
