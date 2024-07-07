package command;

import lombok.Data;

/**
 * ClassName: Response
 * Package: command
 * Description:
 *
 * @Author wbl
 * @Create 2024/7/3 13:49
 * @Version 1.0
 */
//reponse数据包
@Data
public class Response <T>{
    private int code;
    private String msg;
    private T data;

    protected  static <T> Response<T>build(int code,String msg,T data){
        Response<T>response=new Response<T>();
        response.code=code;
        response.msg=msg;
        response.data=data;
        return response;
    }

    public static <T>Response<T>build(CodeEnum codeEnum,T data){
        return Response.build(codeEnum.getCode(),codeEnum.getMsg(),data );
    }

}
