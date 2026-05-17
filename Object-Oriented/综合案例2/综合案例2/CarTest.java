package 综合案例2;
import java.util.Scanner;
public class CarTest {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Car[] c=new Car[3]; //创建一个长度为3的数组，数组元素类型是Car
        /*for(int i=1;i<=c.length;i++){
            System.out.println("请输入第"+i+"辆车的品牌，价格，颜色：");
            String brand=sc.next();
            double price=sc.nextDouble();
            String color=sc.next();
            c[i-1]=new Car(brand,price,color); //每次循环都创建一个对象，对象属性值不同
        }
        for(int i=0;i<c.length;i++){
            System.out.println("第"+(i+1)+"辆车的品牌是："+c[i].getBrand()+"，价格是："+c[i].getPrice()+"，颜色是："+c[i].getColor());
        }*/
        for(int i=0;i<c.length;i++){
            Car car=new Car(); //每次循环都创建一个对象，对象属性值不同
            System.out.println("请输入第"+i+"辆车的品牌，价格，颜色：");
            String brand=sc.next();
            double price=sc.nextDouble();
            String color=sc.next();
            car.setBrand(brand);
            car.setPrice(price);
            car.setColor(color);
            c[i]=car; //将car对象赋值给数组的第i个元素
        }
        for(int i=0;i<c.length;i++){
            System.out.println("第"+(i+1)+"辆车的品牌是："+c[i].getBrand()+"，价格是："+c[i].getPrice()+"，颜色是："+c[i].getColor());
        }
        sc.close();

        //单辆车
        /*System.out.println("请分别输入汽车品牌，价格，颜色：");
        String brand=sc.next();
        double price=sc.nextDouble();
        String color=sc.next();
        Car c=new Car(brand,price,color);
        System.out.println("汽车品牌："+c.getBrand());
        System.out.println("汽车价格："+c.getPrice());
        System.out.println("汽车颜色："+c.getColor());*/
    }
}
