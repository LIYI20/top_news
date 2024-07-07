package service.impl;

import dao.NewsUserDao;
import dao.impl.NewsUserDaoImpl;
import pojo.NewsUser;
import service.NewsUserService;
import util.MD5Util;

/**
 * ClassName: NewsUserServiceImpl
 * Package: service.impl
 * Description:
 *
 * @Author wbl
 * @Create 2024/7/3 18:40
 * @Version 1.0
 */
public class NewsUserServiceImpl implements NewsUserService {
    private NewsUserDao newsUserDao=new NewsUserDaoImpl();
    public NewsUser findByname(String username){
        return newsUserDao.findByname(username);
    }

    public NewsUser findByUid(int uid){
        return newsUserDao.findByUid(uid);
    }

    public boolean register(NewsUser registerUser){
        registerUser.setUserPwd(MD5Util.encrypt(registerUser.getUserPwd()));
        return newsUserDao.register(registerUser);
    }

}
