package taskFour.Demo2;

public class Test {
    public static void main(String[] args){
        final int age=18;
        //age=20; //final修饰的基本数据类型，数据值不能改变
        System.out.println(age);
        final Student s=new Student("张三",19);
        s.setName("李四");
        s.setAge(21); //fianl修饰的引用数据类型，引用值（地址值）不能改变，但引用对象的属性值可以改变
        System.out.println(s.getName()+" "+s.getAge());
        
        final int[] arr={1,2,3,4,5};
        arr[0]=100;
        arr[1]=200;
        arr[2]=300;
        arr[3]=400;
        arr[4]=500; //数组也是引用数据类型，地址值不能改变，但数组中的元素值可以改变
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
