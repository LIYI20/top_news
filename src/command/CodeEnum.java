package command;

/**
 * ClassName: CodeEnum
 * Package: command
 * Description:
 *
 * @Author wbl
 * @Create 2024/7/3 13:55
 * @Version 1.0
 */
public enum CodeEnum {
    SUCCESS(200,"success"),
    USERNAME_ERROR(501,"username_error"),
    USERPASSWORD_ERROR(503,"userPassword_error"),
    NOTLOGIN(504,"notLogin"),
    USERNAME_USED(505,"username_used"),
    SERVER_ERROR(500,"server_error");
    private int code;
    private String msg;
    private CodeEnum(int code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
