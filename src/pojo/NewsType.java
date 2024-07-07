package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * ClassName: NewsType
 * Package: pojo
 * Description:
 *
 * @Author wbl
 * @Create 2024/7/3 15:13
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsType implements Serializable {
    private int tid;
    private String tname;
}
