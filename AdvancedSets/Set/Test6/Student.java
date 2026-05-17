package Test6;

public class Student implements Comparable<Student>{
    private String name;
    private int age;
    public Student(){}
    public Student(String name,int age){
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
    public String toString(){
        return "Student[name="+name+",age="+age+"]";
    }
    @Override
    public int compareTo(Student o) {
        System.out.println("----------------");
        System.out.println("this:"+this);
        System.out.println("o:"+o);
        /*
         * 细节：
         * this：表示当前要添加的元素
         * o：表示已经在红黑树中存在的元素
         * 返回值：
         * 正数：当前要添加的元素大于已存在的元素，存右边
         * 负数：当前要添加的元素小于已存在的元素，存左边
         * 0：当前要添加的元素已存在，舍弃不存储
         */
        return this.getAge()-o.getAge(); //按年龄升序输出
    }
}
