package service.impl;

import dao.NewsHeadlineDao;
import dao.impl.NewsHeadlineDaoImpl;
import pojo.HeadlineDetailVo;
import pojo.HeadlinePageVo;
import pojo.HeadlineQueryVo;
import pojo.NewsHeadline;
import service.NewsHeadlineService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: NewsHeadlineServiceImpl
 * Package: service.impl
 * Description:
 *
 * @Author wbl
 * @Create 2024/7/3 18:40
 * @Version 1.0
 */
public class NewsHeadlineServiceImpl implements NewsHeadlineService {
    private NewsHeadlineDao newsHeadlineDao=new NewsHeadlineDaoImpl();

    public Map<String, Object> findNewsPage(HeadlineQueryVo headlineQueryVo){
        Map<String,Object>pageInfo=new HashMap<>();
        List<HeadlinePageVo>pageList= newsHeadlineDao.findNewsPage(headlineQueryVo);
        pageInfo.put("pageData",pageList);
        int pageNum= headlineQueryVo.getPageNum();
        int pageSize= headlineQueryVo.getPageSize();

        int totalSize=newsHeadlineDao.findAllCount(headlineQueryVo);
        int totalPage=(totalSize+pageSize-1)/pageSize;
        pageInfo.put("pageNum",pageNum);
        pageInfo.put("pageSize",pageSize);
        pageInfo.put("totalPage",totalPage);
        pageInfo.put("totalSize",totalSize);
        return pageInfo;
    }

    public HeadlineDetailVo findHeadlineDetail(int hid){
        newsHeadlineDao.increasePageViews(hid);
        return newsHeadlineDao.findHeadlineDetail(hid);
    }
    public int addNewsheadline(NewsHeadline newsHeadline){
        return newsHeadlineDao.addNewsheadline(newsHeadline);
    }

    public NewsHeadline findHeadlineByHid(int hid){
        return newsHeadlineDao.findHeadlineByHid(hid);
    }
    public   int update(NewsHeadline newsHeadline){
        return newsHeadlineDao.updateHeadline(newsHeadline);
    }

    public int removeByHid(int hid){
        return newsHeadlineDao.removeByHid(hid);
    }

}
