package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * ClassName: HeadlineDetailVo
 * Package: pojo
 * Description:
 *
 * @Author wbl
 * @Create 2024/7/3 18:33
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HeadlineDetailVo implements Serializable {
    private int hid;
    private String title;
    private String article;
    private int type;
    private String typeName;
    private int pageViews;
    private long pastHours;
    private int publisher;
    private String author;
}
