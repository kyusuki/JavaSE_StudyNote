package 综合案例2;
import java.util.Scanner;
public class GirlfridentTest {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Girlfrident[] g=new Girlfrident[4];
        for(int i=1;i<=g.length;i++){
            Girlfrident girl=new Girlfrident(); //每次循环都创建一个对象
            System.out.println("请输入第"+i+"个女友的姓名，年龄，性别，爱好：");
            String name=sc.next();
            int age=sc.nextInt();
            String sex=sc.next();
            String interest=sc.next();
            girl.setName(name);
            girl.setAge(age);
            girl.setSex(sex);
            girl.setInterest(interest);
            g[i-1]=girl; //将girl对象赋值给第i个元素
        }
        for(int i=0;i<g.length;i++){
            System.out.println(g[i].getName()+"的年龄是"+g[i].getAge()+",性别是"+g[i].getSex()+",她喜欢"+g[i].getInterest());
        }
        double avg=0.0,sum=0.0;
        for(int i=0;i<g.length;i++){
            sum+=g[i].getAge();
        }
        avg=sum/g.length;
        for(int i=0;i<g.length;i++){
            if(g[i].getAge()<avg){
                System.out.println(g[i].getName()+"的年龄小于与平均年龄");
            }
        }
        sc.close();
    }
}
