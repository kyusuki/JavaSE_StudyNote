package taskTwo.Demo5;

public class Manage extends Worker{
    private double bonus;
    public Manage(){}
    public Manage(String id,String name,double wage,double bonus){
        super(id,name,wage);
        this.bonus=bonus;
    }
    public void setBonus(double bonus){
        this.bonus=bonus;
    }
    public double getBonus(){
        return bonus;
    }
    @Override
    public void work(){
        super.work();
        System.out.println("管理其他人");
    }
    @Override
    public void eat(){
        super.eat();
        System.out.println("吃西餐");
    }
    public void printM(){
        System.out.println("工号："+getId()+" "+"姓名："+getName()+" "+"工资："+getWage()+" "+"管理奖金："+getBonus());
    }
}
