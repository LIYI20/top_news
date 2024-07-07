package dao.impl;

import dao.BaseDao;
import dao.NewsHeadlineDao;
import pojo.HeadlineDetailVo;
import pojo.HeadlinePageVo;
import pojo.HeadlineQueryVo;
import pojo.NewsHeadline;

import java.util.*;

/**
 * ClassName: NewsHeadlineDaoImpl
 * Package: dao.impl
 * Description:
 *
 * @Author wbl
 * @Create 2024/7/3 18:38
 * @Version 1.0
 */
public class NewsHeadlineDaoImpl extends BaseDao implements NewsHeadlineDao {
   public List<HeadlinePageVo> findNewsPage(HeadlineQueryVo headlineQueryVo){
       //args中存放参数
       List<Object>args=new LinkedList<>();
       String sql="select hid,title,type,page_views pageViews,TIMESTAMPDIFF(HOUR,create_time,NOW()) pastHours,publisher from " +
               "news_headline where is_deleted=0";
       StringBuilder sqlBuffer=new StringBuilder(sql);
       String keywords=headlineQueryVo.getKeyWords();
       if(keywords!=null && !keywords.isEmpty()){
           sqlBuffer.append(" and title like ? ");
           args.add("%"+keywords+"%");
       }
       Integer type=headlineQueryVo.getType();
       if(type!=null&&type!=0){
           sqlBuffer.append(" and type = ? ");
           args.add(type);
       }
       sqlBuffer.append(" order by pastHours, page_views desc");
       //选择页面中元素,sql中的limit第一个参数是offset，后一个是个数
       sqlBuffer.append(" limit ? , ? ");
       Integer start=(headlineQueryVo.getPageNum()-1)*headlineQueryVo.getPageSize();
       args.add(start);
       Integer a=headlineQueryVo.getPageSize();
       args.add(a);
       Object[] argArr=args.toArray();
       System.out.println(sqlBuffer.toString());
       List<HeadlinePageVo>pageData=baseQuery(HeadlinePageVo.class,sqlBuffer.toString(),argArr);
        return pageData;
   }

    public int findAllCount(HeadlineQueryVo headlineQueryVo){
        //args中存放参数
        List<Object>args=new LinkedList<>();
        String sql="select count(1) from news_headline where is_deleted=0 ";
        StringBuilder sqlBuffer=new StringBuilder(sql);
        String keywords=headlineQueryVo.getKeyWords();
        if(keywords!=null && !keywords.isEmpty()){
            sqlBuffer.append(" and title like ? ");
            args.add("%"+keywords+"%");
        }
        Integer type=headlineQueryVo.getType();
        if(type!=null&&type!=0){
            sqlBuffer.append(" and type = ? ");
            args.add(type);
        }
        Object[] argArr=args.toArray();
        System.out.println(sqlBuffer.toString());
    //sql中count(1)返回的是long类型的数据，不能用Integer来接受
       Long count= baseQueryObject(Long.class, sqlBuffer.toString(), argArr);
        // 返回数据
        return count.intValue();
    }

    public  int increasePageViews(int hid){
       String sql="update news_headline set page_views=page_views+1 where hid=?";
       return baseUpdate(sql,hid);
    }

    public HeadlineDetailVo findHeadlineDetail(int hid){
       String sql="select hid,title,article,type,tname typeName,page_views pageViews,TIMESTAMPDIFF(HOUR,create_time,NOW()) pastHours,publisher,nick_name author " +
               " from news_headline h left join news_type t on h.type=t.tid left join news_user u on h.publisher=u.uid where hid=?";
       List<HeadlineDetailVo> list=baseQuery(HeadlineDetailVo.class,sql,hid);
       if(list!=null&&!list.isEmpty())return list.get(0);
       else return null;
    }

    public int addNewsheadline(NewsHeadline newsHeadline){
     String sql="insert into news_headline values(DEFAULT,?,?,?,?,0,NOW(),NOW(),0)";
     return baseUpdate(sql,newsHeadline.getTitle(),
                        newsHeadline.getArticle(),
                        newsHeadline.getType(),
                        newsHeadline.getPublisher());
   }

    public NewsHeadline findHeadlineByHid(int hid){
       String sql="select hid,title,article,type,publisher from news_headline where hid=?";
       List<NewsHeadline>list=baseQuery(NewsHeadline.class,sql,hid);
       if(list!=null&&!list.isEmpty())return list.get(0);
       else return null;
    }

    public int updateHeadline(NewsHeadline newsHeadline){
       String sql="update news_headline set title=?,article=?,type=?,update_time=NOW()where hid=?";
       return baseUpdate(sql,newsHeadline.getTitle(),
               newsHeadline.getArticle(),newsHeadline.getType(),
               newsHeadline.getHid());
    }

    public int removeByHid(int hid){
       String sql="update news_headline set is_deleted=1,update_time=NOW() where hid=?";
       return baseUpdate(sql,hid);
    }
}
