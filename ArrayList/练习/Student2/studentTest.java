package Student2;
import java.util.ArrayList;
import java.util.Scanner;
public class studentTest {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        ArrayList<student> list=new ArrayList<>();
        student s1=new student(110,"张三",123456);
        student s2=new student(111,"李四",123457);
        student s3=new student(112,"王五",123458);
        list.add(s1);
        list.add(s2);
        list.add(s3);
        while(true){
            System.out.println("请输入要查找的id");
            int id=sc.nextInt();
            student s=login(list,id);
            int index=index(list,id);
            if(s!=null&&index!=-1){
                System.out.println("查找成功");
                System.out.println("该学生的索引为："+index);
                System.out.println("姓名："+s.getUsername());
                System.out.println("密码："+s.getPassword());
                break;
            }
            else{
                System.out.println("查找失败");
                continue;
            }
        }
        sc.close();
    }
    public static student login(ArrayList<student> list,int id){
        for(int i=0;i<list.size();i++){
            student s=list.get(i);
            if(s.getId()==id){
                return s;
            }
        }
        return null;
    }
    public static int index(ArrayList<student> list,int id){
        for(int i=0;i<list.size();i++){
            if(list.get(i).getId()==id){
                return i;
            }
        }
        return -1;
    }
}
