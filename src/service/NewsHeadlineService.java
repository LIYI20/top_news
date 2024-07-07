package service;

import pojo.HeadlineDetailVo;
import pojo.HeadlineQueryVo;
import pojo.NewsHeadline;

import java.util.Map;

/**
 * ClassName: NewsHeadlineService
 * Package: service
 * Description:
 *
 * @Author wbl
 * @Create 2024/7/3 18:39
 * @Version 1.0
 */
public interface NewsHeadlineService {
    Map<String, Object> findNewsPage(HeadlineQueryVo headlineQueryVo);

    HeadlineDetailVo findHeadlineDetail(int hid);

    int addNewsheadline(NewsHeadline newsHeadline);

    NewsHeadline findHeadlineByHid(int hid);

    int update(NewsHeadline newsHeadline);

    int removeByHid(int hid);
}
