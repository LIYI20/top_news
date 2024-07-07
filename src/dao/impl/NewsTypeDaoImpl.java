package dao.impl;

import dao.BaseDao;
import dao.NewsTypeDao;
import pojo.NewsType;

import java.util.List;

/**
 * ClassName: NewsTypeImpl
 * Package: dao.impl
 * Description:
 *
 * @Author wbl
 * @Create 2024/7/3 18:38
 * @Version 1.0
 */
public class NewsTypeDaoImpl extends BaseDao implements NewsTypeDao {

    public List<NewsType> findAll(){
        String sql="select tid,tname from news_type";
        return baseQuery(NewsType.class,sql);
    }
}
