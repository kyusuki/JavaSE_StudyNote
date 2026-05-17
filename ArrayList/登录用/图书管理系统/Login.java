package 图书管理系统;
import java.util.Scanner;
import java.util.ArrayList;
public class Login {
    private int count=0; //成员变量
    public boolean login(Scanner sc,ArrayList<User> userList){
        if(userList.isEmpty()){
            System.out.println("用户未注册，请先注册");
            return false;
        }
        System.out.println();
        System.out.println("请输入用户名：");
        String username=sc.next();
        for(int i=0;i<userList.size();i++){
            String name=userList.get(i).getUsername();
            if(!(name.equals(username))){
                System.out.println("用户名不存在");
                return false;
            }
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
                System.out.println("验证码正确");
                codeV=true;
            }
            else{
                System.out.println("验证码错误，请重新输入");
            }
        }
        System.out.println();
        boolean flag=false;
        for(int i=0;i<userList.size();i++){
            User u=userList.get(i);
            String urn=u.getUsername();
            String pwd=u.getPassword();
            if(username.equals(urn)&&password.equals(pwd)){
                flag=true;
                count=0; //登录成功后，重置登录次数
                break;
            }
        }
        if(flag){
            System.out.println("登录成功");
            return true;
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
        return false;
    }
}
