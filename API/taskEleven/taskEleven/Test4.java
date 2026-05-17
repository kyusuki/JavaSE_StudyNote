package taskEleven;
import java.util.Scanner;
import java.util.ArrayList;
public class Test4 {
    public static int sum=0;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        ArrayList<Integer> list=new ArrayList<>();
        while(sum<=200){
            int num=sc.nextInt();
            list.add(num);
            sum+=num;
        }
        System.out.println(sum);
        sc.close();
    }
}
