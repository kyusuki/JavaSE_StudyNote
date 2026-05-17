package Outside;
import java.util.Scanner;
import java.util.ArrayList;
public class Register {
    public void register(Scanner sc,ArrayList<User> userList){
        String username="",password1="",id="",phone="";
        boolean flag=false;
        while(!flag){
            flag=true;
            System.out.print("请输入用户名：");
            username=sc.next();
            if(!isUniqueness(username, userList)){
                System.out.println("用户名已存在");
                flag=false;
            }
            if(!isUserLength(username)){
                System.out.println("用户名长度必须在3-15之间");
                flag=false;
            }
            if(!isLetterNumber(username)){
                System.out.println("用户名必须包含字母或数字");
                flag=false;
            }
        }
        System.out.println("用户名注册成功");
        System.out.println();
        while(!flag){
            flag=true;
            System.out.print("请输入密码：");
            password1=sc.next();
            System.out.println("请再次确认密码：");
            String password2=sc.next();
            if(!password2.equals(password1)){
                System.out.println("两次密码不一致");
                flag=false;
            }
        }
        System.out.println("密码注册成功");
        System.out.println();
        while(flag){
            flag=true;
            System.out.print("请输入身份证号码：");
            id=sc.next();
            if(!isId(id)){
                System.out.println("身份证号码格式错误");
                flag=false;
            }
        }
        System.out.println("身份证号码注册成功");
        System.out.println();
        while(flag){
            flag=true;
            System.out.print("请输入手机号码：");
            phone=sc.next();
            if(!isPhone(phone)){
                System.out.println("手机号码格式错误");
                flag=false;
            }
        }
        System.out.println("手机号码注册成功");
        System.out.println();
        User u=new User(username,password1,id,phone);
        userList.add(u);
        System.out.println("注册成功");
    }
    public static boolean isUniqueness(String username,ArrayList<User> userList){
        for(int i=0;i<userList.size();i++){
            User u=userList.get(i);
            if(u.getUsername().equals(username)){
                return false;
            }
        }
        return true;
    }
    public static boolean isUserLength(String username){
        if(username.length()<3||username.length()>15){
            return false;
        }
        return true;
    }
    public static boolean isLetterNumber(String username){
        for(int i=0;i<username.length();i++){
            char c=username.charAt(i);
            if(!((c>='a'&&c<='z')||(c>='A'&&c<='Z')||(c>='0'&&c<='9'))){
                return false;
            }
        }
        return true;
    }
    public static boolean isId(String id){
        if(id.length()>18){
            return false;
        }
        if(id.charAt(0)=='0'){
            return false;
        }
        for(int i=1;i<=16;i++){
            char c=id.charAt(i);
            if(!(c>='0'&&c<='9')){
                return false;
            }
        }
        if(!(id.charAt(17)=='x'||id.charAt(17)=='X'||(id.charAt(17)>='0'&&id.charAt(17)<=
        9))){
            return false;
        }
        return true;
    }
    public static boolean isPhone(String phone){
        if(phone.length()!=11){
            return false;
        }
        if(phone.charAt(0)=='0'){
            return false;
        }
        for(int i=0;i<phone.length();i++){
            char c=phone.charAt(i);
            if(!(c>='0'&&c<='9')){
                return false;
            }
        }
        return true;
    }
}
