package Phone;
import java.util.ArrayList;
import java.util.Scanner;
public class phoneTest {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        ArrayList<phone> ph=new ArrayList<>();
        while(true){
            phone p=new phone();
            System.out.println("请输入手机品牌");
            String brand=sc.next();
            System.out.println("请输入该手机价格");
            double price=sc.nextDouble();
            sc.nextLine();
            p.setBrand(brand);
            p.setPrice(price);
            ph.add(p);
            System.out.println("是否还要继续输入(Y/N)");
            String choice=sc.nextLine();
            if(choice.equals("N")||choice.equals("n")){
                break;
            }
        }
        ArrayList<phone> result=compare(ph);
        if(result.size()>0){
            System.out.print("低于3000的手机有");
            for(int i=0;i<result.size();i++){
                phone p=result.get(i);
                if(i<result.size()-1){
                    System.out.print(p.getBrand()+",");
                }
                else if(i==result.size()-1){
                    System.out.println(p.getBrand());
                }
            }
        }
        else{
            System.out.println("没有低于3000的手机");
        }
        sc.close();
    }
    public static ArrayList<phone> compare(ArrayList<phone> ph){
        ArrayList<phone> result=new ArrayList<>();
        for(int i=0;i<ph.size();i++){
            phone p=ph.get(i);
            if(p.getPrice()<3000){
                result.add(p);
            }
        }
        return result;
    }
}
