package taskSeven.Demo3;

public class Test {
    public static void main(String[] args){
        Outer.Inner inner=new Outer.Inner();
        inner.show1();
        
        //inner.show2();
        Outer.Inner.show2();
    }
}
