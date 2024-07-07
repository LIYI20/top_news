package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * ClassName: HeadlinePageVo
 * Package: pojo
 * Description:
 *
 * @Author wbl
 * @Create 2024/7/3 18:31
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HeadlinePageVo implements Serializable {
    private int hid;
    private String title;
    private int type;
    private int pageViews;
    private long pastHours;
    private int publisher;
}
