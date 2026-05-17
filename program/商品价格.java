import java.util.Scanner;
public class 商品价格 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        double price=sc.nextInt();
        System.out.println("请输入会员等级");
        int VIP=sc.nextInt();
        if(VIP>=0&&VIP<=3){
            if(VIP==1){
                price=price*0.7;
                System.out.println(price);
            }
            else if(VIP==2){
                price=price*0.6;
                System.out.println(price);
            }
            else if(VIP==3){
                price=price*0.5;
                System.out.println(price);
            }
            else{
                System.out.println(price);
            }
        }
        else{
            System.out.println("输入错误");
        }
        sc.close();
    }
}