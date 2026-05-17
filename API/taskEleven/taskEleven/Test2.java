package taskEleven;

public class Test2 {
    public static void main(String[] args){
        //以前对包装类的计算方法
        /*
         * 1.先把对象进行拆箱，变成基本数据类型
         * 2.对基本数据类型进行计算
         * 3.把计算的结果在进行装箱
         */
        //Integer i1=new Integer(1);
        //Integer i2=new Integer(2);
        //int result=i1.intValue()+i2.intValue();
        //Integer i3=new Integer(result);
        //System.out.println(i3);
        

        //JDK5开始，支持自动拆箱与自动装箱
        /*
         * 自动拆箱：把包装类自动变成其基本数据类型
         * 自动装箱：基本数据类型自动转成对应包装类
         */
        Integer i=10; //自动装箱
        int j=i; //自动拆箱
        System.out.println(i+j);
    }
}
