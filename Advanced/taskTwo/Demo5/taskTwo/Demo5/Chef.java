package taskTwo.Demo5;

public class Chef extends Worker{
    public Chef(){}
    public Chef(String id,String name,double wage){
        super(id,name,wage);
    }
    @Override
    public void work(){
        super.work();
        System.out.println("炒菜");
    }
    @Override
    public void eat(){
        super.eat();
        System.out.println("吃中餐");
    }
    public void printC(){
        System.out.println("工号："+getId()+" "+"姓名："+getName()+" "+"工资："+getWage());
    }
}
