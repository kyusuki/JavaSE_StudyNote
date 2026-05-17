package 图书管理系统;
import java.util.Scanner;
import java.util.ArrayList;
public class App {
    public static void main(String[] args){
        System.out.println("欢迎使用学生管理系统");
        ArrayList<User> userList=new ArrayList<>(); //全局用户列表
        Scanner sc=new Scanner(System.in); //全局扫描器
        Login l=new Login(); //只创建一次Login对象
        User admin1=new User("gyf","111111","111111111111111111","11111111111",1);
        User admin2=new User("dashuaige","666666","122222222222222222","12222222222",1);
        userList.add(admin1);
        userList.add(admin2);
        while(true){
            System.out.println("请选择：1.登录 2.注册 3.退出");
            String choice=sc.next();
            switch(choice){
                case "1"->{
                    //while(true){
                        User u=l.login(sc,userList);
                        if(u!=null){
                            BookTest bt=new BookTest(sc); //创建BookTest对象
                            bt.test(u); //进入图书管理系统
                        }
                        else{
                            System.out.println("1.重新登录 2.忘记密码 3.退出");
                            String choice2=sc.next();
                            switch(choice2){
                                case "1"->{
                                    break;
                                }
                                case "2"->{
                                    Forget f=new Forget(); //创建Forget对象
                                    f.forget(sc,userList); //调用忘记密码方法
                                    break;
                                }
                                case "3"->{
                                    System.exit(0);
                                }
                                default->System.out.println("输入错误");
                            }
                        }
                    //}
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
