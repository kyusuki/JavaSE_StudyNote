package Outside;
import java.util.Scanner;
import java.util.ArrayList;
public class Login {
    public boolean login(Scanner sc,ArrayList<User> userList){
        String username="",password="";
        int count=0;
        while(true){
            System.out.print("请输入用户名：");
            username=sc.next();
            if(!isRegister(username, userList)){
                System.out.println("用户名不存在");
                continue;
            }
            else{
                break;
            }
        }
        while(count<=3){
            System.out.print("请输入密码：");
            password=sc.next();
            int i=index(username,userList);
            if(!(password.equals(userList.get(i).getPassword()))){
                System.out.println("密码错误，还剩"+(3-count)+"次机会");
                count++;
            }
            else{
                break;
            }
        }
        if(count>=3){
            System.out.println("登录失败");
            return false;
        }
        while(true){
            String code2=getCode();
            System.out.println("验证码为："+code2);
            System.out.print("请输入验证码：");
            String code1=sc.next();
            if(code1.equals(code2)){
                System.out.println("登录成功");
                break;
            }
            else{
                System.out.println("验证码错误");
            }
        }
        return true;
    }
    public static boolean isRegister(String username,ArrayList<User> userList){
        for(int i=0;i<userList.size();i++){
            String u=userList.get(i).getUsername();
            if(u.equals(username)){
                return false;
            }
        }
        return true;
    }
    public static int index(String username,ArrayList<User> userList){
        for(int i=0;i<userList.size();i++){
            String u=userList.get(i).getUsername();
            if(u.equals(username)){
                return i;
            }
        }
        return -1;
    }
    public static String getCode(){
        VerificationCode vc=new VerificationCode();
        String code=vc.getVerification();
        return code;
    }
}
