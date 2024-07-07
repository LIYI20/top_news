package service;

import pojo.NewsUser;

/**
 * ClassName: NewsUserService
 * Package: service
 * Description:
 *
 * @Author wbl
 * @Create 2024/7/3 18:39
 * @Version 1.0
 */
public interface NewsUserService {

    NewsUser findByname(String username);

    NewsUser findByUid(int uid);

    boolean register(NewsUser registerUser);
}
