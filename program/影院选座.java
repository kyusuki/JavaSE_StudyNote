import java.util.Scanner;
public class 影院选座 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int ticket=sc.nextInt();
        if(ticket<=100&&ticket>=1){
            System.out.println("选座成功");
            if(ticket%2==0){
                System.out.println("坐右边");
            }
            else{
                System.out.println("坐左边");
            }
        }
        else{
            System.out.println("选座失败");
        }    
        sc.close();
    }
}