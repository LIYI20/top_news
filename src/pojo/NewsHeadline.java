package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * ClassName: NewsHeadline
 * Package: pojo
 * Description:
 *
 * @Author wbl
 * @Create 2024/7/3 15:15
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsHeadline implements Serializable {
    private int hid;
    private String title;
    private String article;
    private int type;
    private int publisher;
    private int pageViews;
    private Date createTime;
    private Date updateTime;
    private int isDeleted;
}
