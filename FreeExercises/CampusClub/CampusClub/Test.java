package CampusClub;

import java.util.Scanner;

public class Test {
    static Club club=new Club("乐子俱乐部");
    static AdminMember admin1=new AdminMember("张三","001","社长");
    static AdminMember admin2=new AdminMember("李四","002","部长");
    static AdminMember admin3=new AdminMember("王五","003","部长");
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

    }
    //展示菜单
    public static void showMenu(int choice){
        if(choice==1){
            System.out.println("1.添加成员");
            System.out.println("2.添加活动");
            System.out.println("3.查看成员列表");
            System.out.println("4.查看活动列表");
            System.out.println("5.查看记录");
            System.out.println("6.活动报名");
            System.out.println("7.活动签到");
            System.out.println("8.查看积分排名");
            System.out.println("9.活动发布");
            System.out.println("0.退出");
        }
        else if(choice==2){
            System.out.println("1.活动报名");
            System.out.println("2.活动签到");
            System.out.println("3.查看积分排名");
            System.out.println("4.退出");
        }
    }
    //添加成员
    public static void addMember(Scanner sc,Member member){
        System.out.print("请输入成员姓名：");
        String name=sc.next();
        System.out.print("请输入成员ID：");
        String memberId=sc.next();
        member.setName(name);
        member.setMemberId(memberId);
        club.addMember(member);
        System.out.println("成员"+member.getName()+"加入"+club.getClubName()+"成功");
    }
    //添加活动
    public static void addActivity(Scanner sc,Activity activity){
        
    }
}
