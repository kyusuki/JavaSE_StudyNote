package Generic.Test6;

import java.util.ArrayList;

public class test2 {
    public static void main(String[] args){
        ArrayList<YeYe> lis1=new ArrayList<>();
        ArrayList<BaBa> lis2=new ArrayList<>();
        ArrayList<ErEr> lis3=new ArrayList<>();
        ArrayList<Student> lis4=new ArrayList<>();
        
        method(lis1);
        method(lis2);
        method(lis3);
        method(lis4);
    }
    /*
     * 此泛型方法可以接收任意类型的ArrayList，但这也是弊端
     */
    public static <E> void method(ArrayList<E> list){

    }
}
class YeYe{

}
class BaBa extends YeYe{

}
class ErEr extends BaBa{

}
class Student{

}
