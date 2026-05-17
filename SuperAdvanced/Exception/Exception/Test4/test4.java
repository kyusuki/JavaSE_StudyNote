package Exception.Test4;

import java.util.Scanner;

public class test4 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(true){
            try{
                System.out.print("name:");
                String name=sc.next();
                System.out.print("age:");
                int age=sc.nextInt();
                npy p=new npy(name,age);
                if(p.getName().length()>=3&&p.getName().length()<=10){
                    if(p.getAge()>=18&&p.getAge()<=35){
                        System.out.println("npy:"+name+" "+age);
                        break;
                    }
                    else{
                        System.out.println("年龄必须在18-35岁之间");
                    }
                }
                else{
                    System.out.println("姓名长度必须在3-10个字符之间");
                }
            }catch(Exception e){
                System.out.println("输入信息错误，请重新输入");
                sc.nextLine();
            }
        }
        sc.close();
    }
}
