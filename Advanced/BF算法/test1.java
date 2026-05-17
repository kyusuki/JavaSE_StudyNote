package Generic.Test6;

import java.util.ArrayList;

public class test1 {
    public static void main(String[] args){
        //泛型不具备继承性，但是数据具备继承性
        
        ArrayList<YeYe> lis1=new ArrayList<>();
        //ArrayList<BaBa> lis2=new ArrayList<>();
        //ArrayList<ErEr> lis3=new ArrayList<>();
        
        method(lis1);
        //method(lis2); //报错
        //method(lis3); //报错
    }
    public static void method(ArrayList<YeYe> list){

    }
}
class YeYe{

}
class BaBa extends YeYe{

}
class ErEr extends BaBa{

}
