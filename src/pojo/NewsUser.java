package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * ClassName: NewsUser
 * Package: pojo
 * Description:
 *
 * @Author wbl
 * @Create 2024/7/3 14:17
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsUser implements Serializable {
    private int uid;
    private String username;
    private String userPwd;
    private String nickName;
}
