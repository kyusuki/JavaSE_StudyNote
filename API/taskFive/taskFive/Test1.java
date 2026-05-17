package taskFive;

public class Test1 {
    public static void main(String[] args){
        Object obj=new Object();
        String str1=obj.toString();
        System.out.println(str1); //java.lang.Object@5caf905d
        
        /*
         * 细节
         * System：类名
         * out：静态变量
         * System.out：获取打印的对象
         * println()：方法
         * 参数：表示打印的内容
         * 当处理一个对象时，底层会调用对象的toString()方法，把对象变成字符串
         */
        System.out.println(obj); //java.lang.Object@5caf905d
        String str2="hello";
        String str3="Hello";
        System.out.println(str2.equals(str3));
        
        /*
         * 1.如果没有重写equals方法，那么默认使用Object类的equals方法比较，比较的是地址值
         * 2.重写equals方法后，比较的就是对象的属性值
         */
        Student stu1=new Student("zhangsan",18);
        Student stu2=new Student("zhangsan",18);
        /*
         * 底层调用对象的toString()方法
         * 默认继承的Object类，本应该返回的是地址值
         * 由于在子类Student中重写了toString()，返回的就是对象的属性值
         */
        System.out.println(stu1);
        System.out.println(stu1.equals(stu2));

        String s="abc";
        StringBuilder sb=new StringBuilder("abc");
        /*
         * 细节
         * 1.equals方法时被s调用的，而s是字符串
         * 2.字符串中的equals方法，是先判断参数是否为字符串
         * 3.若是字符串则比较内部属性
         * 4.若不是字符串，直接返回false；
         */
        System.out.println(s.equals(sb)); //false
        /*
         * 细节
         * 1.equals方法是被sb调用的，而sb是StringBuilder类型
         * 2.在StringBuilder当中，没有equals方法，用的是Object类中的equals方法
         * 3.Object类中的equals方法，比较的是地址值
         * 4.因为s和sb是不同的对象，所以地址值不同，返回false
         */
        System.out.println(sb.equals(s)); //false
    }
}