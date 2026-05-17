package 升级版;
import java.util.Scanner;
import java.util.ArrayList;
public class App {
    public static void main(String[] args){
        System.out.println("欢迎使用学生管理系统");
        ArrayList<User> userList=new ArrayList<>(); //全局用户列表
        Scanner sc=new Scanner(System.in); //全局扫描器
        while(true){
            System.out.println("请选择：1.登录 2.注册 3.退出");
            String choice=sc.next();
            switch(choice){
                case "1"->{
                    Login l=new Login(); //创建Login对象
                    boolean ls=l.login(sc,userList); //调用登录方法
                    if(ls){
                        SMS ss=new SMS(); //创建SMS对象
                        ss.sms(sc); //进入学生管理系统
                    }
                    else{
                        System.exit(0);
                    }
                }
                case "2"->{
                    Register r=new Register(); //创建Register对象
                    r.register(sc,userList); //调用注册方法
                }
                case "3"->{
                    System.out.println("退出系统");
                    sc.close();
                    System.exit(0);
                }
                default->System.out.println("输入错误");
            }
        }    
    }
}