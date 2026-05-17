import java.util.Scanner;
public class 机票查询 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入机票类型：1.经济舱 2.商务舱");
        int type=sc.nextInt();
        System.out.println("请输入机票数量");
        int num=sc.nextInt();
        switch(type){
            case 1:
                System.out.println("需支付："+num*300+"￥");
                break;
            case 2:
                System.out.println("需支付："+num*500+"￥");
                break;
            default:
                System.out.println("输入错误");
                break;
        }
        sc.close();
    }
}
