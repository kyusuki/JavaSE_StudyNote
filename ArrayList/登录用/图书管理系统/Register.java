package 图书管理系统;
import java.util.Scanner;
import java.util.ArrayList;
public class Register {
    //创建注册成员方法
    public void register(Scanner sc,ArrayList<User> userList){
        User u=new User();
        //用户名注册
        while(true){
            System.out.println("请输入用户名");
            String username=sc.next();
            if(username.length()<3||username.length()>15){
                System.out.println("用户名长度必须在3-15之间");
                continue;
            }
            int count=0;
            for(int i=0;i<username.length();i++){
                char c=username.charAt(i);
                if(c>='A'&&c<='Z'||c>='a'&&c<='z'){
                    count++;
                }
            }
            if(count==0){
                System.out.println("用户名必须包含一个字母");
                continue;
            }
            if(!isLetterDigit(username)){
                System.out.println("用户名必须包含字母或数字");
                continue;
            }
            if(isExist(userList, username)){
                System.out.println("用户名已存在");
                continue;
            }
            u.setUsername(username);
            System.out.println("用户名注册成功");
            break;
        }
        System.out.println();
        //密码注册
        while(true){
            System.out.println("请输入密码");
            String password1=sc.next();
            System.out.println("请再次输入密码");
            String password2=sc.next();
            if(password1.equals(password2)){
                u.setPassword(password1);
                System.out.println("密码注册成功");
                break;
            }
            else{
                System.out.println("密码注册失败");
            }
        }
        System.out.println();
        //身份证验证
        while(true){
            System.out.println("请输入身份证号");
            String id=sc.next();
            if(isId(id)){
                u.setId(id);
                break;
            }
            else{
                System.out.println("身份证号格式错误");
            }
        }
        System.out.println();
        //手机号验证
        while(true){
            System.out.println("请输入手机号");
            String phone=sc.next();
            if(isPhone(phone)){
                u.setPhone(phone);
                break;
            }
            else{
                System.out.println("手机号格式错误");
            }
        }
        userList.add(u); //所有信息验证通过后，再添加到用户列表
        System.out.println("用户"+u.getUsername()+"注册成功");
        System.out.println();
    }
    //判断用户名是否已存在
    public static boolean isExist(ArrayList<User> userList,String username){
        for(int i=0;i<userList.size();i++){
            String name=userList.get(i).getUsername();
            if(name.equals(username)){
                return true;
            }
        }
        return false;
    }
    //通过用户名获取索引
    public static int getIndex(ArrayList<User> userList,String username){
        for(int i=0;i<userList.size();i++){
            String name=userList.get(i).getUsername();
            if(name.equals(username)){
                return i;
            }
        }
        return -1;
    }
    //判断是否为大写，小写或数字
    public static boolean isLetterDigit(String str){
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(!((c>='A'&&c<='Z')||(c>='a'&&c<='z')||(c>='0'&&c<='9'))){
                return false;
            }
        }
        return true;
    }
    //身份证号码验证
    public static boolean isId(String id){
        if(id.length()!=18){
            return false;
        }
        if(id.charAt(0)=='0'){
            return false;
        }
        String s=id.substring(0, 17);
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c<'0'||c>'9'){
                return false;
            }
        }
        char last=id.charAt(17);
        if(!((last>='0'&&last<='9')||(last=='X'||last=='x'))){
            return false;
        }
        return true;
    }
    //手机号验证
    public static boolean isPhone(String phone){
        if(phone.length()!=11){
            return false;
        }
        if(phone.charAt(0)!='1'){
            return false;
        }
        for(int i=0;i<phone.length();i++){
            char c=phone.charAt(i);
            if(c<'0'||c>'9'){
                return false;
            }
        }
        return true;
    }
}
