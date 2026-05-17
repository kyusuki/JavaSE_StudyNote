package taskSix;

public class StudentTest {
    public static void main(String[] args){
        Student[] arr=new Student[3];
        Student stu1=new Student(110,"张三",18);
        Student stu2=new Student(111,"李四",20);
        Student stu3=new Student(112,"王五",22);
        arr[0]=stu1;
        arr[1]=stu2;
        arr[2]=stu3;
        f4(arr);
        System.out.println();
        Student stu4=new Student(113,"赵六",24);
        //查询并加1
        int index=f3(arr,110);
        if(index>=0){
            arr[index].setAge(arr[index].getAge()+1);
            f4(arr);
            System.out.println();
        }
        else{
            System.out.println("该学号不存在");
        }
        //唯一性判断，添加stu4
        boolean temp1=f1(arr,stu4.getId());
        if(temp1){
            System.out.println("该学号已存在");
        }
        else{
            int count=f5(arr);
            if(count==arr.length){
                arr=f2(arr);
                arr[count]=stu4;
                f4(arr);
                System.out.println();
            }
            else{
                arr[count]=stu4;
                f4(arr);
                System.out.println();
            }
        }
        //删除
        int index1=f3(arr,112);
        if(index1>=0){
            arr[index1]=null;
            f4(arr);
        }
        else{
            System.out.println("该学号不存在");
        }
    }
    //唯一性判断
    public static boolean f1(Student[] arr,int id){
        for(int i=0;i<arr.length;i++){
            if(arr[i].getId()==id){
                return true;
            }
        }
        return false;
    }
    //创建新数组
    public static Student[] f2(Student[] arr){
        Student[] newArr=new Student[arr.length+1];
        for(int i=0;i<arr.length;i++){
            newArr[i]=arr[i];
        }
        return newArr;
    }
    //获取索引值
    public static int f3(Student[] arr,int id){
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=null){
                if(arr[i].getId()==id){
                    return i;
                }
            }
        }
        return -1;
    }
    //打印
    public static void f4(Student[] arr){
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=null){
                System.out.println(arr[i].getId()+" "+arr[i].getName()+" "+arr[i].getAge());
            }
        }
    }
    //返回存在元素个数
    public static int f5(Student[] arr){
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=null){
                count++;
            }
        }
        return count;
    }
}
