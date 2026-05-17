package 图书管理系统;
import java.util.Scanner;
import java.util.ArrayList;
public class Login {
    private int count=0; //成员变量
    //返回User类型
    public User login(Scanner sc,ArrayList<User> userList){
        if(userList.isEmpty()){
            System.out.println("用户未注册，请先注册");
            return null;
        }
        System.out.println();
        System.out.println("请输入用户名：");
        String username=sc.next();
        User user=null; //创建User对象，默认用户为空
        for(User u:userList){
            String name=u.getUsername();
            if(name.equals(username)){
                user=u;
                break;
            }
        }
        if(user==null){
            System.out.println("用户名不存在");
            return null;
        }
        System.out.println();
        System.out.println("请输入密码：");
        String password=sc.next();
        VerificationCode v=new VerificationCode();
        boolean codeV=false;
        while(!codeV){
            String code1=v.getCode();
            System.out.println("验证码："+code1);
            System.out.println("请输入验证码：");
            String code2=sc.next();
            if(code2.equals(code1)){
                codeV=true;
            }
            else{
                System.out.println("验证码错误，请重新输入");
            }
        }
        System.out.println();
        if(user.getPassword().equals(password)){
            System.out.println("登录成功");
            count=0;
            return user;
        }
        else{
            count++;
            int remain=3-count;
            if(remain>0){
                System.out.println("用户名或密码错误，还剩"+remain+"次机会");
            }
            else{
                System.out.println("登录失败");
                System.exit(0); //三次失败，直接退出
            }
        }
        return null;
    }
}
