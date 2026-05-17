package Exception.Test5;

import java.util.Scanner;

public class test5 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        NPY p=new NPY();
        while(true){
            try{
                System.out.print("name:");
                String name=sc.next();
                System.out.print("age:");
                int age=sc.nextInt();
                p.setName(name);
                p.setAge(age);
            }catch(NameFormatException e){
                System.out.println("name error:"+e.getMessage());
                continue;
            }catch(AgeOutOfBoundsException e){
                System.out.println("age error:"+e.getMessage());
                continue;
            }
            break;
        }
        System.out.println(p);
        sc.close();
    }
}
