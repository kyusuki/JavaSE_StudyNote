package 综合案例2;
import java.util.Scanner;
public class PhoneTest {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Phone[] p=new Phone[3]; //创建一个长度为3的数组，数组元素类型是Phone
        for(int i=0;i<p.length;i++){
            Phone phone=new Phone(); //每次循环都创建一个对象
            System.out.println("请分别输入第"+(i+1)+"部手机的品牌，价格，颜色：");
            String brand=sc.next();
            double price=sc.nextDouble();
            String color=sc.next();
            phone.setBrand(brand);
            phone.setPrice(price);
            phone.setColor(color);
            p[i]=phone; //将phone对象赋值给数组的第i个元素
        }   
        for(int i=0;i<p.length;i++){
            System.out.println("第"+(i+1)+"部手机的品牌是："+p[i].getBrand()+"，价格是："+p[i].getPrice()+"，颜色是："+p[i].getColor());
        }
        double avg=0.0,sum=0.0;
        for(int i=0;i<p.length;i++){
            sum+=p[i].getPrice();
        }
        avg=sum/p.length;
        System.out.println("三部手机的平均价格为："+avg);
    }
}
