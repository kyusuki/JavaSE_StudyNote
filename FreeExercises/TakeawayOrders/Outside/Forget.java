package Outside;
import java.util.Scanner;
import java.util.ArrayList;
public class Forget {
    public void forget(Scanner sc,ArrayList<User> userList){
        System.out.print("请输入用户名：");
        String username=sc.next();
        if(!isRegister(username, userList)){
            return;
        }
        int i=index(username,userList);
        System.out.print("请输入身份证号码：");
        String id=sc.next();
        System.out.print("请输入手机号码：");
        String phone=sc.next();
        if(!isIdPhone(id,phone,userList)){
            System.out.println("身份信息错误");
            return;
        }
        while(true){
            System.out.print("请输入新密码：");
            String newpassword1=sc.next();
            System.out.print("请确认新密码：");
            String newpassword2=sc.next();
            if(!(newpassword1.equals(newpassword2))){
                System.out.println("密码输入错误");
                continue;
            }
            else{
                System.out.println("修改成功");
                userList.get(i).setPassword(newpassword1);
            }
        }
        
    }
    public static boolean isRegister(String username,ArrayList<User> userList){
        for(int i=0;i<userList.size();i++){
            String u=userList.get(i).getUsername();
            if(!(u.equals(username))){
                System.out.println("用户名不存在");
                return false;
            }
        }
        return true;
    }
    public static boolean isIdPhone(String id,String phone,ArrayList<User> userList){
        for(int i=0;i<userList.size();i++){
            String id1=userList.get(i).getId();
            String phone1=userList.get(i).getPhone();
            if(!(id1.equals(id)&&phone1.equals(phone))){
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
}
