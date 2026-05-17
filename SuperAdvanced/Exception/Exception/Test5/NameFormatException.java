package Exception.Test5;

public class NameFormatException extends RuntimeException {
    /*
     * 技巧：
     * NameFormat：当前异常的名字
     * Exception：表示当前类是一个异常类
     * 
     * 自定义异常继承关系：
     * 运行时：RuntimeException 表示是由于参数错误而导致的异常
     * 编译时：Exception 提醒调用者检查本地信息
     */
    public NameFormatException(){}
    public NameFormatException(String message){
        super(message);
    }
}
