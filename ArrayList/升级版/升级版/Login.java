package 升级版;
import java.util.Scanner;
import java.util.ArrayList;
public class Login {
    public boolean login(Scanner sc,ArrayList<User> userList){
        if(userList.isEmpty()){
            System.out.println("用户未注册，请先注册");
            return false;
        }
        System.out.println("请输入用户名：");
        String username=sc.next();
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
                System.out.println("验证码正确");
                codeV=true;
            }
            else{
                System.out.println("验证码错误，请重新输入");
            }
        }
        int count=0,remain=0;
        boolean flag=false;
        for(int i=0;i<userList.size();i++){
            User u=userList.get(i);
            String urn=u.getUsername();
            String pwd=u.getPassword();
            if(username.equals(urn)&&password.equals(pwd)){
                flag=true;
                break;
            }
        }
        if(flag){
            System.out.println("登录成功");
            return true;
        }
        else{
            count++;
            remain=3-count;
            if(remain>0){
                System.out.println("用户名或密码错误，还剩"+remain+"次机会");
            }
            else{
                System.out.println("登录失败");
            }
        }
        return false;
    }
}
