package 练习;
import java.util.Scanner;
public class IDcheck {
    public static void main(String[] args){
        //Integer.parseInt() 字符串转整数
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入身份证号码");
        String id;
        while(true){
            id=sc.nextLine();
            if(id.length()==18){
                break;
            }
            else{
                System.out.println("输入错误");
            }
        }
        String birthyear=id.substring(6,10);
        String birthmonth=id.substring(10,12);
        String birthday=id.substring(12,14);
        String sex=id.substring(17);
        System.out.println("出生年月日："+birthyear+"年"+birthmonth+"月"+birthday+"日");
        if(Integer.parseInt(sex)%2==0){
            System.out.println("性别为：女");
        }
        else{
            System.out.println("性别为：男");
        }
        sc.close();
    }
}
