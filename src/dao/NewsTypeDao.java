package dao;

import pojo.NewsType;

import java.util.List;

/**
 * ClassName: NewsTypeDao
 * Package: dao
 * Description:
 *
 * @Author wbl
 * @Create 2024/7/3 18:37
 * @Version 1.0
 */
public interface NewsTypeDao {
    List<NewsType> findAll();
}
