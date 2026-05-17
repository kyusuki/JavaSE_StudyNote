package taskSeven.Demo5;

public class Test {
    public static void main(String[] args){
        Swim s=new Swim(){
            @Override
            public void swim(){
                System.out.println("狗刨");
            }
        };
        s.swim();
        
        new Swim(){
            @Override
            public void swim(){
                System.out.println("蛙泳");
            }
        }.swim();
        
        method2(new Animal(){
            @Override
            public void eat(){
                System.out.println("狗吃骨头");
            }
        });
    }
    public static void method2(Animal a){
        a.eat();
    }
}
