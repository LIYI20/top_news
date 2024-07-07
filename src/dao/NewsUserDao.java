package dao;

import pojo.NewsUser;

/**
 * ClassName: NewsUserDao
 * Package: dao
 * Description:
 *
 * @Author wbl
 * @Create 2024/7/3 18:37
 * @Version 1.0
 */
public interface NewsUserDao {
    NewsUser findByname(String username);

    NewsUser findByUid(int uid);

    boolean register(NewsUser registerUser);
}
