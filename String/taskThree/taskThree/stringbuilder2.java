package taskThree;

public class stringbuilder2 {
    public static void main(String[] args){
        StringBuilder sb=new StringBuilder();
        //添加元素
        sb.append("aaa");
        sb.append("bbb");
        sb.append("ccc");
        sb.append("ddd");
        //链式编程
        //sb.append("aaa").append("bbb").append("ccc").append("ddd");
        System.out.println(sb); //还只是容器

        //变回字符串
        String str=sb.toString();
        System.out.println(str);
    }
}
