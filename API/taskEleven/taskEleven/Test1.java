package taskEleven;

public class Test1 {
    public static void main(String[] args){
        /*
         * public Integer(int value)                         根据传递的整数创建Integer对象
         * public Integer(String s)                          根据传递的字符串创建Integer对象
         * public static Integer valueOf(int i)              根据传递的整数创建Integer对象
         * public static Integer valueOf(String s)           根据传递的字符串创建Integer对象
         * public static INteger valueOf(String s,int radix) 根据传递的字符串和进制创建Integer对象
         */

        //需求1（JDK5之前的方式）
        //Integer i1=new Integer(12);
        //Integer i2=new Integer("12");
        //System.out.println(i1);
        //System.out.println(i2);

        //需求2
        Integer i3=Integer.valueOf(11);
        Integer i4=Integer.valueOf("11");
        Integer i5=Integer.valueOf("11", 2);
        System.out.println(i3);
        System.out.println(i4);
        System.out.println(i5);

        //构造方法与静态方法的区别
        //System.out.println(i1==i2); //false
        Integer i6=Integer.valueOf(127);
        Integer i7=Integer.valueOf(127);
        System.out.println(i6==i7); //true
        Integer i8=Integer.valueOf(128);
        Integer i9=Integer.valueOf(128);
        System.out.println(i8==i9); //false
    }
}
