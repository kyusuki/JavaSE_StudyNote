package taskFive;

public class Test2 {
    public static void main(String[] args) throws CloneNotSupportedException{
        int[] date={1,2,3,4,5,6,7};
        User u1=new User(112,"zhangsan","zzz123","girl2",date);
        User u2=(User)u1.clone();
        System.out.println(u1);
        System.out.println(u2);
    }
}
