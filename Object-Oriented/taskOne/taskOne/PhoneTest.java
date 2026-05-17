package taskOne;

public class PhoneTest {
    public static void main(String[] args){
        Phone p=new Phone();
        p.brand="小米";
        p.price=1999;
        System.out.println("品牌 "+p.brand);
        System.out.println("价格 "+p.price);
        p.call();
        p.playGame();
    }
}
