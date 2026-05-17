package Inside;
import java.util.Scanner;
import java.util.ArrayList;
public class Test {
    private static Scanner sc=new Scanner(System.in);
    private static ArrayList<Member> m=new ArrayList<>();
    private static ArrayList<VIPMember> vm=new ArrayList<>();
    private static Gym g=new Gym("翻斗花园健身房",new ArrayList<>(),new ArrayList<>());
    public static void main(String[] args){
        while(true){
            showMenu();
            int choice=sc.nextInt();
            switch(choice){
                case 1->{
                    addMember();
                }
                case 2->{
                    addVIPMember();
                }
                case 3->{
                    reCharge();
                }
                case 4->{
                    checkBalance();
                }
                case 5->{
                    addCourse();
                }
                case 6->{
                    updateCourseStock();
                }
                case 7->{
                    enrollCourse();
                }
                case 8->{
                    showMember();
                }
                case 9->{
                    showCourse();
                }
                case 0->{
                    System.out.println("已成功退出系统");
                    System.exit(0);
                }
                default->{
                    System.out.println("请输入正确的选择");
                }
            }
        }
    }
    public static void showMenu(){
        System.out.println("-----欢迎使用会员管理系统-----");
        System.out.println("      1.添加普通会员");
        System.out.println("      2.添加VIP会员");
        System.out.println("      3.会员充值");
        System.out.println("      4.查询余额");
        System.out.println("      5.添加课程");
        System.out.println("      6.更新课程库存");
        System.out.println("      7.会员报名课程");
        System.out.println("      8.显示所有会员");
        System.out.println("      9.显示所有课程");
        System.out.println("      0.退出系统");
        System.out.println("-----------------------------");
        System.out.print("请输入功能：");
    }
    //添加普通会员
    public static void addMember(){
        String id="";
        while(true){
            System.out.print("设置你的会员ID（比如zs001）：");
            String id1=sc.next();
            if(!(checkID(id))){
                System.out.println("该会员ID已存在，请重新输入");
                continue;
            }
            id=id1;
            break;
        }
        System.out.print("输入你的真实姓名：");
        String name=sc.next();
        Member member=new Member();
        member.setMemberId(id);
        member.setName(name);
        m.add(member);
        g.getMemberList().add(member);
        System.out.println("你的会员信息添加成功");
        member.setStatus("正常");
        System.out.println();
        System.out.println("你的当前余额为："+member.getBalance()+"元");
        System.out.println();
    }
    //添加VIP会员
    public static void addVIPMember(){
        String id="";
        while(true){
            System.out.print("请输入您尊贵的会员ID（比如VIPzs001）：");
            String id1=sc.next();
            if(!(checkID(id1))){
                System.out.println("您的ID已存在，请重新输入");
                continue;
            }
            id=id1;
            break;
        }
        System.out.print("请输入您尊贵的真实姓名：");
        String name=sc.next();
        VIPMember vipmember=new VIPMember();
        vipmember.setMemberId(id);
        vipmember.setName(name);
        vm.add(vipmember);
        g.getMemberList().add(vipmember);
        System.out.println("您尊贵的会员信息添加成功");
        vipmember.setStatus("正常");
        System.out.println();
        vipmember.setBalance(520);
        vipmember.setDiscount(0.8);
        System.out.println("您的当前余额为："+vipmember.getBalance()+"元");
        System.out.println();
    }
    //检验ID唯一性
    public static boolean checkID(String id){
        for(int i=0;i<m.size();i++){
            String id1=m.get(i).getMemberId();
            if(id.equals(id1)){
                return false;
            }
        }
        for(int i=0;i<vm.size();i++){
            String id2=vm.get(i).getMemberId();
            if(id.equals(id2)){
                return false;
            }
        }
        return true;
    }
    //返回普通会员当前ID对应索引值
    public static Member findMember(String id){
        for(int i=0;i<m.size();i++){
            String id1=m.get(i).getMemberId();
            if(id.equals(id1)){
                return m.get(i);
            }
        }
        return null;
    }
    //返回VIP会员当前ID对应索引值
    public static VIPMember findVIPMember(String id){
        for(int i=0;i<vm.size();i++){
            String id2=vm.get(i).getMemberId();
            if(id.equals(id2)){
                return vm.get(i);
            }
        }
        return null;
    }
    //判断用户是否为VIP会员
    public static boolean isVIP(String id){
        for(int i=0;i<vm.size();i++){
            String id1=vm.get(i).getMemberId();
            if(id.equals(id1)){
                return true; //是VIP
            }
        }
        return false; //不是VIP
    }
    //会员充值
    public static void reCharge(){
        System.out.print("请输入会员ID：");
        String id=sc.next();
        Member member=findMember(id);
        VIPMember vipmember=findVIPMember(id);
        if(checkID(id)){
            System.out.println("该会员ID不存在");
            return;
        }
        System.out.print("请输入充值金额：");
        double money=sc.nextDouble();
        if(member!=null){
            member.recharge(money);
        }
        else if(vipmember!=null){
            vipmember.recharge(money);
        }
        System.out.println();
    }
    //余额查询
    public static void checkBalance(){
        System.out.print("请输入会员ID：");
        String id=sc.next();
        Member member=findMember(id);
        VIPMember vipmember=findVIPMember(id);
        if(checkID(id)){
            System.out.println("该会员ID不存在");
            return;
        }
        if(member!=null){
            member.checkBalance();
        }
        else if(vipmember!=null){
            vipmember.checkBalance();
        }
        System.out.println();
    }
    //添加课程
    public static void addCourse(){
        Course course=new Course();
        System.out.print("请输入课程ID：");
        String courseid=sc.next();
        System.out.print("请输入课程名称：");
        String coursename=sc.next();
        System.out.print("请输入课程价格：");
        double price=sc.nextDouble();
        System.out.print("请输入课程库存：");
        int stock=sc.nextInt();
        course.setCourseId(courseid);
        course.setCourseName(coursename);
        course.setPrice(price);
        course.setStock(stock);
        course.setStatus("待开课");
        g.addCourse(course);
        System.out.println("课程添加成功");
        System.out.println();
    }
    //课程库存更新
    public static void updateCourseStock(){
        System.out.print("请输入课程ID：");
        String courseid=sc.next();
        System.out.print("请输入课程库存变更值：");
        int stockchange=sc.nextInt();
        g.updateCourseStock(courseid, stockchange);
        System.out.println();
    }
    //检验课程ID是否存在
    public static Course findCourse(String courseid){
        for(int i=0;i<g.getCourseList().size();i++){
            String id=g.getCourseList().get(i).getCourseId();
            if(id.equals(courseid)){
                return g.getCourseList().get(i);
            }
        }
        return null;
    }
    //会员报名课程
    public static void enrollCourse(){
        System.out.print("请输入会员ID：");
        String id=sc.next();
        if(checkID(id)){
            System.out.println("该会员ID不存在");
            return;
        }
        Member member=findMember(id);
        if(member==null){
            member=findVIPMember(id);
        }
        System.out.print("请输入课程ID：");
        String courseid=sc.next();
        Course course=findCourse(courseid);
        if(course==null){
            System.out.println("该课程ID不存在");
            return;
        }
        boolean result=member.enrollCourse(course, g);
        if(result){
            course.setStatus("进行中");
            System.out.println("会员报名成功");
        }
        System.out.println();
    }
    //显示所有会员信息
    public static void showMember(){
        System.out.println("普通会员信息：");
        if(m.isEmpty()){
            System.out.println("暂无普通会员信息");
        }
        else{
            for(int i=0;i<m.size();i++){
                System.out.println(m.get(i)+" "+m.get(i).getBalance()+" "+m.get(i).getStatus());
            }
        }
        System.out.println();
        System.out.println("VIP会员信息：");
        if(vm.isEmpty()){
            System.out.println("暂无VIP会员信息");
        }
        else{
            for(int i=0;i<vm.size();i++){
                System.out.println(vm.get(i)+" "+vm.get(i).getBalance()+" "+vm.get(i).getStatus());
            }
        }
        System.out.println();
    }
    //显示所有课程信息
    public static void showCourse(){
        System.out.println("课程信息：");
        if(g.getCourseList().isEmpty()){
            System.out.println("暂无课程信息");
        }
        else{
            for(int i=0;i<g.getCourseList().size();i++){
                System.out.println(g.getCourseList().get(i)+" "+g.getCourseList().get(i).getPrice()+" "+g.getCourseList().get(i).getStock()+" "+g.getCourseList().get(i).getStatus());
            }
        }
        System.out.println();
    }
}
