package Test13;

import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class AutomaticRollCall2 {
    public static void main(String[] args){
        ArrayList<Student> listBoy = new ArrayList<>();
        listBoy.add(new Student("路飞","男"));
        listBoy.add(new Student("漩涡鸣人","男"));
        listBoy.add(new Student("艾伦·耶格尔","男"));
        listBoy.add(new Student("埼玉","男"));
        listBoy.add(new Student("桐人","男"));
        listBoy.add(new Student("鲁路修","男"));
        listBoy.add(new Student("黑崎一护","男"));
        listBoy.add(new Student("五条悟","男"));
        listBoy.add(new Student("炭治郎","男"));
        listBoy.add(new Student("利威尔","男"));
        ArrayList<Student> listGirl = new ArrayList<>();
        listGirl.add(new Student("娜美","女"));
        listGirl.add(new Student("春野樱","女"));
        listGirl.add(new Student("三笠·阿克曼","女"));
        listGirl.add(new Student("龙卷","女"));
        listGirl.add(new Student("亚丝娜","女"));
        listGirl.add(new Student("C.C.","女"));
        listGirl.add(new Student("露琪亚","女"));
        listGirl.add(new Student("钉崎野蔷薇","女"));
        listGirl.add(new Student("祢豆子","女"));
        listGirl.add(new Student("赫里斯塔·兰斯","女"));
        ArrayList<Integer> listSex=new ArrayList<>();
        Collections.addAll(listSex,1,1,1,1,1,1,1,0,0,0); //性别男选中概率为70%，性别女选中概率为30%
        Collections.shuffle(listSex);
        Random r=new Random();
        int index=r.nextInt(listSex.size());
        if(listSex.get(index)==1){
            int indexB=r.nextInt(listBoy.size());
            System.out.println("姓名："+listBoy.get(indexB).getName()+" 你被选中了");
        }
        else if(listSex.get(index)==0){
            int indexG=r.nextInt(listGirl.size());
            System.out.println("姓名："+listGirl.get(indexG).getName()+" 你被选中了");
        }
    }
}
class Student{
    private String name;
    private String sex;
    public Student(){}
    public Student(String name,String sex){
        this.name=name;
        this.sex=sex;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getSex(){
        return sex;
    }
    public void setSex(String sex){
        this.sex=sex;
    }
}
