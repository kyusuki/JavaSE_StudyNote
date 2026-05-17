package taskThree;

public class stringbuilder {
    public static void main(String[] args){
        StringBuilder sb=new StringBuilder("hello");
        /*StringBuilder
        System.out.println(sb); //因为StringBuilder是Java提供的一个类，打印对象不是地址值而是属性值*/
        
        //添加元素
        sb.append(1);
        sb.append(2.3);
        sb.append(true); //hello12.3true

        //反转
        sb.reverse(); //eurt3.21olleh

        //获取长度
        int len=sb.length();
        System.out.println(len); //13

        System.out.println(sb);
    }
}
