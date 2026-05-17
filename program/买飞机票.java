import java.util.Scanner;
public class 买飞机票 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int month;
        do{
            System.out.println("请输入购票月份(1-12)：");
            month=sc.nextInt();
            if(month<1||month>12){
                System.out.println("输入错误，请重新输入");
            }
        }while(month<1||month>12);
        System.out.println("请选择购票类型：1.头等舱 2.经济舱");
        int type=sc.nextInt();
        System.out.println("请输入购票人数：");
        int num=sc.nextInt();
        double price=0.0;
        price=f(month,type,num);
        if(price==-1){
            System.out.println("输入错误,请退出重新购票");
        }
        else{
            System.out.println("你需要支付金额为："+price);
        }
        sc.close();
    }
    public static double f(int month,int type,int num){
        double price=0.0;
        if(month>=5&&month<=10){
            if(type==1){
                price=500*num*0.9;
                return price;
            }
            else if(type==2){
                price=500*num*0.85;
                return price;
            }
            else{
                return -1;
            }
        }
        else{
            if(type==1){
                price=500*num*0.7;
                return price;
            }
            else if(type==2){
                price=500*num*0.65;
                return price;
            }
            else{
                return -1;
            }
        }
    }
}
