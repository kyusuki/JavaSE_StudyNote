package Outside;
import java.util.Scanner;
import java.util.ArrayList;
public class LoginApp {
    public static void main(String[] args){
        System.out.println("欢迎使用外卖系统");
        Scanner sc=new Scanner(System.in);
        ArrayList<User> userList=new ArrayList<>();
        while(true){
            System.out.println("1.登录 2.注册 3.退出");
            int choice=sc.nextInt();
            switch(choice){
                case 1 ->{
                    while(true){
                        Login l=new Login();
                        boolean b=l.login(sc,userList);
                        if(!b){
                            System.out.println("1.重新登录 2.忘记密码 3.退出");
                            int choice2=sc.nextInt();
                            switch(choice2){
                                case 1 ->{
                                    break;
                                }
                                case 2 ->{
                                    Forget f=new Forget();
                                    f.forget(sc,userList);
                                    break;
                                }
                                case 3 ->{
                                    System.out.println("退出成功");
                                    System.exit(0);
                                }
                                default ->{
                                    System.out.println("输入错误");
                                }
                            }
                        }
                        else{
                            
                        }
                    }
                }
                case 2 ->{
                    Register r=new Register();
                    r.register(sc,userList);
                }
                case 3 ->{
                    System.out.println("退出成功");
                    System.exit(0);
                }
                default ->{
                    System.out.println("输入错误");
                }
            }
        }
    }
}
