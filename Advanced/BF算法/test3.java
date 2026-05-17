package Generic.Test6;

import java.util.ArrayList;

public class test3 {
    public static void main(String[] args){
        ArrayList<YeYe> lis1=new ArrayList<>();
        ArrayList<BaBa> lis2=new ArrayList<>();
        ArrayList<ErEr> lis3=new ArrayList<>();
        //ArrayList<Student> lis4=new ArrayList<>();
        
        method(lis1);
        method(lis2);
        method(lis3);
        //method(lis4); //报错
    }
    /*
     * 为避免使用任意类型的ArrayList，比如只想使用YeYe类型
     * 可使用通配符 ? 来表示任意类型
     * ? extends E：表示可以传递E或者E所有子类类型
     * ? super E：表示可以传递E或者E所有父类类型
     */
    public static void method(ArrayList<? extends YeYe> list){

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
