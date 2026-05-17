import java.util.Scanner;
public class 工作日 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int day=sc.nextInt();
        switch(day){
            case 1,2,3,4,5:
                System.out.println("工作日");
                break;
            case 6,7:
                System.out.println("休息日");
                break;
            default:
                System.out.println("输入错误");
                break;
        }
        sc.close();
    }
}
