import java.util.Scanner;
public class 考试奖励 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int rank=sc.nextInt();
        if(rank==1){
            System.out.println("小红成为小明女朋友");
        }
        else{
            System.out.println("小红没有成为小明女朋友");
        }
        sc.close();
    }
}
