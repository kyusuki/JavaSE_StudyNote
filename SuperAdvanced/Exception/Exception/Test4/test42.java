package Exception.Test4;

import java.util.Scanner;

public class test42 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("请输入姓名：");
        String name=sc.next();
        System.out.print("请输入年龄：");
        int age=sc.nextInt();
        npy2 npy=new npy2(name,age);
        System.out.println(npy.getName()+"-"+npy.getAge());
        sc.close();
    }
}
