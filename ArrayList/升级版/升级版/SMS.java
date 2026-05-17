package 升级版;
import java.util.Scanner;
import java.util.ArrayList;
public class SMS {
    public void sms(Scanner sc){
        ArrayList<student> list=new ArrayList<>();
        loop:while(true){
            System.out.println("--------欢迎使用学生管理系统--------");
            System.out.println("    1.添加学生"+"      "+"2.删除学生");
            System.out.println("    3.修改学生"+"      "+"4.查询学生");
            System.out.println("    5.退出系统");
            System.out.println("请输入选择");
            int choice=sc.nextInt();
            switch(choice){
                case 1->addStudent(list,sc);
                case 2->deleteStudent(list,sc);
                case 3->updateStudent(list,sc);
                case 4->queryStudent(list);
                case 5->{
                    System.out.println("已退出系统");
                    break loop;  //或者   System.exit(0);   停止虚拟机运行
                }
                default->System.out.println("输入错误");
            }
        }
    }
    //添加学生
    public static void addStudent(ArrayList<student> list,Scanner sc){
        student stu=new student();
        String id;
        while(true){
            System.out.println("请输入学号");
            id=sc.next();
            boolean flag=isExist(list, id);
            if(flag){
                System.out.println("该学号已存在，请重新输入");
            }
            else{
                stu.setId(id);
                break;
            }
        }
        System.out.println("请输入姓名");
        String name=sc.next();
        System.out.println("请输入年龄");
        int age=sc.nextInt();
        System.out.println("请输入家庭住址");
        String address=sc.next();
        stu.setName(name);
        stu.setAge(age);
        stu.setAddress(address); //或者直接使用  student stu=new student(id,name,age,address);
        list.add(stu);
        System.out.println("添加成功");
    }
    //删除学生
    public static void deleteStudent(ArrayList<student> list,Scanner sc){
        System.out.println("请输入要删除的学号");
        String id=sc.next();
        int index=getIndex(list,id);
        if(index>=0){
            list.remove(index);
            System.out.println("删除成功");
        }
        else{
            System.out.println("学号不存在，删除失败");
        }
    }
    //修改学生
    public static void updateStudent(ArrayList<student> list,Scanner sc){
        System.out.println("请输入要修改的学号");
        String id=sc.next();
        int index=getIndex(list,id);
        if(index==-1){
            System.out.println("该学号不存在，修改失败");
            return;
        }
        student stu=list.get(index);
        System.out.println("请输入新姓名");
        String newname=sc.next();
        System.out.println("请输入新年龄");
        int newage=sc.nextInt();
        System.out.println("请输入新家庭住址");
        String newaddress=sc.next();
        stu.setName(newname);
        stu.setAge(newage);
        stu.setAddress(newaddress);
        System.out.println("修改成功");
    }
    //查询学生
    public static void queryStudent(ArrayList<student> list){
        if(list.size()==0){
            System.out.println("当前无学生信息");
            return;
        }
        System.out.println("学号\t姓名\t年龄\t家庭住址");
        for(int i=0;i<list.size();i++){
            student stu=list.get(i);
            System.out.println(stu.getId()+"\t"+stu.getName()+"\t"+stu.getAge()+"\t"+stu.getAddress());
        }
    }
    //判断学号是否存在
    public static boolean isExist(ArrayList<student> list,String id){
        for(int i=0;i<list.size();i++){
            student stu=list.get(i);
            String sid=stu.getId();
            if(sid.equals(id)){
                return true;
            }
        }
        return false;
    }
    //通过学号获取索引
    public static int getIndex(ArrayList<student> list,String id){
        for(int i=0;i<list.size();i++){
            student stu=list.get(i);
            String sid=stu.getId();
            if(sid.equals(id)){
                return i;
            }
        }
        return -1;
    }
}
