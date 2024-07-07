package service;

import pojo.NewsType;

import java.util.List;

/**
 * ClassName: NewsTypeService
 * Package: service
 * Description:
 *
 * @Author wbl
 * @Create 2024/7/3 18:39
 * @Version 1.0
 */
public interface NewsTypeService {
    List<NewsType> findAll();
}
