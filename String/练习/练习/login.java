package 练习;
import java.util.Scanner;
public class login {
    public static void main(String[] args){
        //1.定义两个变量记录正确的用户名和密码
        String rightUsername="advent";
        String rigthPassword="259";
        //2.获取用户输入的用户名和密码
        /*Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username=sc.next();
        System.out.println("请输入密码：");
        String password=sc.next();
        //3.比较
        if(username.equals(rightUsername)&&password.equals(rigthPassword)){
            System.out.println("登录成功");
        }
        else{
            System.out.println("用户名或密码错误");
        }*/
        
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<3;i++){
            System.out.println("请输入用户名：");
            String username=sc.next();
            System.out.println("请输入密码：");
            String password=sc.next();
            if(username.equals(rightUsername)&&password.equals(rigthPassword)){
                System.out.println("登录成功");
                break;
            }
            else{
                System.out.println("用户名或密码错误");
                if(i<2){
                    System.out.println("请重新输入用户名和密码");
                }
                else{
                    System.out.println("登陆失败，账号锁定");
                }
            }
        }
        sc.close();
    }
}
