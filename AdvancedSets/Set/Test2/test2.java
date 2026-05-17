package Test2;

public class test2 {
    public static void main(String[] args){
        /*
         * 没有重写hashCode方法，不同对象计算出的哈希值是不同的 
         * 已经重写hashCode方法，不同对象只要属性值相同，计算出的哈希值就是一样的
         * 在小部分情况下，不同的属性值或者不同的地址值计算出来的哈希值也有可能一样
         */
        Student s1=new Student("张三",18);
        Student s2=new Student("张三",18);
        System.out.println(s1.hashCode()); //41359092 -> 24022538
        System.out.println(s2.hashCode()); //149928006 -> 24022538
    }
}
