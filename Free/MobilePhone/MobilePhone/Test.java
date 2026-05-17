package MobilePhone;
import java.util.Scanner;
public class Test {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Class c=new Class();
        System.out.println("请分别输入品牌，型号，价格");
        String brand=sc.nextLine();
        c.setBrand(brand);
        String model=sc.nextLine();
        c.setModel(model);
        double price=sc.nextInt();
        c.setPrice(price);
        System.out.println("品牌"+c.getBrand()+"型号"+c.getModel()+"价格"+c.getPrice());
        sc.close();
    }
}
