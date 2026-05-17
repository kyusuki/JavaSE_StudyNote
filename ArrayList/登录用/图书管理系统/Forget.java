package 图书管理系统;
import java.util.Scanner;
import java.util.ArrayList;
public class Forget {
    public void forget(Scanner sc,ArrayList<User> userList){
        System.out.println();
        System.out.println("请输入用户名：");
        String username=sc.next();
        User u=null; //先假设用户不存在
        for(int i=0;i<userList.size();i++){
            String name=userList.get(i).getUsername();
            if(name.equals(username)){
                u=userList.get(i); //找到该用户
                break;
            }
        }
        if(u==null){
            System.out.println("该用户名未注册");
            return;
        }
        System.out.println();
        System.out.println("请输入身份证号码：");
        String id1=sc.next();
        System.out.println();
        System.out.println("请输入手机号码：");
        String phone1=sc.next();
        String id2=u.getId();
        String phone2=u.getPhone();
        System.out.println();
        if(id1.equals(id2)&&phone1.equals(phone2)){
            System.out.println("请输入新密码：");
            String newPassword=sc.next();
            u.setPassword(newPassword);
            System.out.println("密码修改成功");  
        }
        else{
            System.out.println("账号信息不一致");
        }
    }
}

