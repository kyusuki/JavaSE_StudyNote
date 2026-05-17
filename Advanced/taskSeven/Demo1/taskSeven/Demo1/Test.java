package taskSeven.Demo1;

public class Test {
    public static void main(String[] args){
        Outer.Inner inner=new Outer().new Inner();
        inner.show();
    }
}
