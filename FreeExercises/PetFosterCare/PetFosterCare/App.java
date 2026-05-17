package PetFosterCare;
import java.util.Scanner;
import java.util.Random;
public class App {
    private static Scanner sc=new Scanner(System.in);
    private static Random r=new Random();
    private static FosterCenter center=new FosterCenter();
    public static void main(String[] args){
        String centerName="潘宏收养所";
        center.init(); //初始化宠物列表
        System.out.println("欢迎使用"+centerName+"寄养系统");   
        int maxCapacity=50;
        center.setCenterName(centerName);
        center.setMaxCapacity(maxCapacity);
        while(true){
            showMenu();
            System.out.print("请输入你的选择：");
            int choice=sc.nextInt();
            switch(choice){
                case 1:{
                    System.out.print("请输入宠物类型（1.狗 2.猫）：");
                    int type=sc.nextInt();
                    if(type==1){
                        addDog();
                    }
                    else if(type==2){
                        addCat();
                    }
                    else{
                        System.out.println("你眼睛瞎啊");
                    }
                    break;
                }
                case 2:{
                    showPet();
                    break;
                }
                case 3:{
                    recivePet();
                    break;
                }
                case 4:{
                    querypet();
                    break;
                }
                case 5:{
                    System.out.println("谢谢使用"+centerName+"寄养系统");
                    System.exit(0);
                }
            }

        }
    }
    //菜单界面
    public static void showMenu(){
        System.out.println("1.添加宠物");
        System.out.println("2.查看寄养中的宠物");
        System.out.println("3.接走登记服务");
        System.out.println("4.查询寄养记录");
        System.out.println("5.退出系统");
    }
    //添加宠物功能
    public static void addDog(){
        System.out.print("请输入宠物昵称：");
        String nickname=sc.next();
        System.out.print("请输入宠物品种：");
        String breed=sc.next();
        System.out.print("请输入宠物年龄：");
        int age=sc.nextInt();
        System.out.print("请输入宠物体重：");
        double weight=sc.nextDouble();
        System.out.print("请输入你的姓名：");
        String owner=sc.next();
        System.out.print("是否需要遛弯（true/false）：");
        boolean walk=sc.nextBoolean();
        System.out.print("请输入需要寄养的天数：");
        int days=sc.nextInt();
        while(true){
            String id=setDogID();
            if(isIDExist(id)){
                continue;
            }
            System.out.println("请选择宠物ID：");
            System.out.println(id);
            System.out.print("请输入你的选择（Yes/No）：");
            String choice=sc.next();
            if(choice.equals("Yes")){
                Pet dog=new Dog(id,nickname,age,weight,owner,"待寄养",breed,walk);
                center.acceptPet(dog,days);
                break;
            }
        }
    }
    public static void addCat(){
        System.out.print("请输入宠物昵称：");
        String nickname=sc.next();
        System.out.print("请输入宠物毛发类型（短毛/长毛）：");
        String hair=sc.next();
        System.out.print("请输入宠物年龄：");
        int age=sc.nextInt();
        System.out.print("请输入宠物体重：");
        double weight=sc.nextDouble();
        System.out.print("请输入你的姓名：");
        String owner=sc.next();
        System.out.print("是否需要梳毛（true/false）：");
        boolean groom=sc.nextBoolean();
        System.out.print("请输入需要寄养的天数：");
        int days=sc.nextInt();
        while(true){
            String id=setCatID();
            if(isIDExist(id)){
                continue;
            }
            System.out.println("请选择宠物ID：");
            System.out.println(id);
            System.out.print("请输入你的选择（Yes/No）：");
            String choice=sc.next();
            if(choice.equals("Yes")){
                Pet cat=new Cat(id,nickname,age,weight,owner,"待寄养",hair,groom);
                center.acceptPet(cat,days);
                break;
            }
        }
    }
    //随机生成宠物ID
    public static String setDogID(){
        int id=r.nextInt(10000);
        String petid="D"+id;
        return petid;
    }
    public static String setCatID(){
        int id=r.nextInt(10000);
        String petid="C"+id;
        return petid;
    }
    //查看寄养中的宠物
    public static void showPet(){
        System.out.print("请输入现在宠物状态（待寄养/寄养中/已接走）：");
        String status=sc.next();
        center.queryPets(status);
    }
    //接走登记服务
    public static void recivePet(){
        System.out.print("请输入宠物ID：");
        String petid=sc.next();
        if(isIDExist(petid)){
            center.pickUpPet(petid);
            System.out.println("接走登记成功");
        }
        else{
            System.out.println("宠物ID不存在");
            return;
        }
    }
    //查询寄养记录
    public static void querypet(){
        System.out.println("该服务正在更新中，请谅解...");
    }
    //ID唯一性
    public static boolean isIDExist(String petid){
        for(int i=0;i<center.getFosteringPets().size();i++){
            String id=center.getFosteringPets().get(i).getPetId();
            if(id.equals(petid)){
                return true;
            }
        }
        return false;
    }
}
