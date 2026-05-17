package Student1;
import java.util.ArrayList;
import java.util.Scanner;
public class studentTest {
    public static void main(String[] args){
        ArrayList<student> list=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入添加的学生个数");
        int num=sc.nextInt();
        for(int i=0;i<num;i++){
            student s=new student(); //创建学生对象
            System.out.println("请输入第"+(i+1)+"个学生的姓名和年龄");
            String name=sc.next();
            int age=sc.nextInt();
            s.setName(name);
            s.setAge(age);
            list.add(s); //将学生对象添加到集合中
        }
        for(int i=0;i<list.size();i++){
            student s=list.get(i); //从集合中获取学生对象
            System.out.println(s.getName()+" "+s.getAge());
        }
        sc.close();
    }
}
