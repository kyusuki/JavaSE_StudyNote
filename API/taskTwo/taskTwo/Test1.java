package taskTwo;

public class Test1 {
    public static void main(String[] args){
        //System.exit(0); //退出虚拟机
        System.out.println(System.currentTimeMillis()); //当前时间毫秒值
        System.out.println();
        int[] arr1={1,2,3,4,5,6,7,8,9,10};
        int[] arr2=new int[10];
        //拷贝参数（源数组，源数组开始索引，目标数组，目标数组开始索引，拷贝长度）
        System.arraycopy(arr1, 6, arr2, 2, 3);
        for(int i=0;i<arr2.length;i++){
            System.out.print(arr2[i]+" "); //0 0 7 8 9 0 0 0 0 0
        }
        System.out.println();
        System.out.println();
        Student s1=new Student("张三",18);
        Student s2=new Student("李四",19);
        Student s3=new Student("王五",20);
        Student[] stu1={s1,s2,s3};
        //Student[] stu2=new Student[3];
        Person[] stu2=new Person[3];
        System.arraycopy(stu1, 0, stu2, 0, 3);
        for(int i=0;i<stu2.length;i++){
            System.out.println(stu2[i].getName()+" "+stu2[i].getAge());
        }
    }
}
class Person{
    private String name;
    private int age;
    public Person(){}
    public Person(String name,int age){
        this.name=name;
        this.age=age;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age=age;
    }
}
class Student extends Person{
    public Student(){}
    public Student(String name,int age){
        super(name,age);
    }
}
