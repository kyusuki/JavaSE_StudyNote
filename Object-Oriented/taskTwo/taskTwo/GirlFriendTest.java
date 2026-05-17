package taskTwo;

public class GirlFriendTest {
    public static void main(String[] args){
        GirlFriend gf=new GirlFriend();
        //赋值
        gf.setName("神里绫华");
        gf.setAge(18);
        gf.setBWH("B80/W57/H85");
        System.out.println("女朋友叫"+gf.getName());
        System.out.println("女朋友今年"+gf.getAge()+"岁");
        System.out.println("女朋友三围是"+gf.getBWH());
        gf.sleep();
        gf.eat();
    }
}
