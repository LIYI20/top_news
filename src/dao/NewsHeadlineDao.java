package dao;

import pojo.HeadlineDetailVo;
import pojo.HeadlinePageVo;
import pojo.HeadlineQueryVo;
import pojo.NewsHeadline;

import java.util.List;

/**
 * ClassName: NewsHeadLineDao
 * Package: dao
 * Description:
 *
 * @Author wbl
 * @Create 2024/7/3 18:37
 * @Version 1.0
 */
public interface NewsHeadlineDao {
    List<HeadlinePageVo> findNewsPage(HeadlineQueryVo headlineQueryVo);

    int findAllCount(HeadlineQueryVo headlineQueryVo);

    int increasePageViews(int hid);

    HeadlineDetailVo findHeadlineDetail(int hid);

    int addNewsheadline(NewsHeadline newsHeadline);

    NewsHeadline findHeadlineByHid(int hid);

    int updateHeadline(NewsHeadline newsHeadline);

    int removeByHid(int hid);
}
