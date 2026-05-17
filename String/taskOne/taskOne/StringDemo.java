package taskOne;

public class StringDemo {
    public static void main(String[] args){
        //1.使用直接赋值获取一个字符串对象
        String s1="abc";
        System.out.println(s1);

        //2.使用new关键字获取一个字符串对象
        //空参构造
        String s2=new String();
        System.out.println("12"+s2+"34");
        //有参构造
        String s3=new String("你好 Java");
        System.out.println(s3);
        //创建字符数组
        char[] chs={'d','e','f'};
        String s4=new String(chs);
        System.out.println(s4);
        chs[0]='G'; //只改变了字符数组，不会改变字符串对象
        System.out.println(s4); //def
        //创建字节数组
        byte[] bys={97,98,99};
        String s5=new String(bys);
        System.out.println(s5); //abc
    }
}
