package 综合案例2;

public class StudentTest {
    public static void main(String[] args){
        /*要求
          1.再次添加一个学生对象，并在添加的时候进行学号的唯一性判断
          2.添加完毕后，遍历所有学生信息
          3.通过id删除学生信息
          4.删除完毕后，遍历所有学生信息
          5.查询数组id是否存在*/
        Student[] s=new Student[3];
        Student stu1=new Student(111,"张三",18);
        Student stu2=new Student(112,"李四",19);
        Student stu3=new Student(113,"王五",20);
        s[0]=stu1;
        s[1]=stu2;
        s[2]=stu3;
        Student stu4=new Student(114,"赵六",21);
        //查询
        int index1=getindex(s,112);
        if(index1>=0){
            int age1=s[index1].getAge();
            age1++;
            s[index1].setAge(age1);
        }
        else{
            System.out.println("该学号不存在");
        }
        //唯一性判断
        boolean flag=contains(s,stu4.getId());
        if(flag){
            System.out.println("该学号已存在");
        }
        else{
            int count=getcount(s);
            if(count==s.length){
                //创建新数组
                s=creat(s);
                s[count]=stu4;
                print(s);
            }
            else{
                s[count]=stu4;
                print(s);
            }
        }
        //删除
        int  index=getindex(s,112);
        if(index>=0){
            s[index]=null;
            print(s);
        }
        else{
            System.out.println("该学号不存在");
        }

    }
    //唯一性判断
    public static boolean contains(Student[] s,int id){
        for(int i=0;i<s.length;i++){
            if(s[i].getId()==id){
                return true;
            }
        }
        return false;
    }
    //判断存在元素个数
    public static int getcount(Student[] s){
        int count=0;
        for(int i=0;i<s.length;i++){
            if(s[i]!=null){
                count++;
            }
        }
        return count;
    }
    //创建新数组
    public static Student[] creat(Student[] s){
        Student[] s1=new Student[s.length+1];
        for(int i=0;i<s.length;i++){
            s1[i]=s[i];
        }
        return s1;
    }
    //print
    public static void print(Student[] s){
        for(int i=0;i<s.length;i++){
            Student stu=s[i];
            if(stu!=null){
                System.out.println(stu.getId()+" "+stu.getName()+" "+stu.getAge());
            }
        }
    }
    //找id在数组中的索引
    public static int getindex(Student[] s,int id){
        for(int i=0;i<s.length;i++){
            Student stu=s[i];
            if(stu!=null){
                int index=stu.getId();
                if(index==id){
                    return i;
                }
            }
        }
        return -1;
    }
}
