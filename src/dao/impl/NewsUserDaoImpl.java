package dao.impl;

import dao.BaseDao;
import dao.NewsUserDao;
import pojo.NewsUser;

import java.util.List;

/**
 * ClassName: NewsUserDaoImpl
 * Package: dao.impl
 * Description:
 *
 * @Author wbl
 * @Create 2024/7/3 18:38
 * @Version 1.0
 */
public class NewsUserDaoImpl extends BaseDao implements NewsUserDao {

    public NewsUser findByname(String username){
        String sql ="select uid,username,user_pwd userPwd ,nick_name nickName from news_user where username = ?";
        // 调用BaseDao公共查询方法
        List<NewsUser> newsUserList = baseQuery(NewsUser.class, sql, username);
        // 如果找到,返回集合中的第一个数据(其实就一个)
        if (null != newsUserList && newsUserList.size()>0){
            return  newsUserList.get(0);
        }
        return null;

    }

    public NewsUser findByUid(int uid){
        String sql="select uid,username,user_pwd userPwd,nick_name nickName from news_user where uid=?";
        List<NewsUser>newsUserList=baseQuery(NewsUser.class,sql,uid);
        if(newsUserList==null)return null;
        else return newsUserList.get(0);
    }

    public boolean register(NewsUser registerUser){
        System.out.println(registerUser);
        String sql="insert into news_user values(DEFAULT,?,?,?)";
        int res=baseUpdate(sql,registerUser.getUsername(),registerUser.getUserPwd(),registerUser.getNickName());
        return res != 0;
    }
}
