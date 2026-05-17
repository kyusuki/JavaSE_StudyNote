package taskOne.Demo3;
import java.util.ArrayList;
public class StudentUtil {
    private StudentUtil(){} //私有化构造方法
    public static Student getMaxAge(ArrayList<Student> list){
        Student maxA=list.get(0);
        for(int i=0;i<list.size();i++){
            int age=list.get(i).getAge();
            if(age>maxA.getAge()){
                maxA=list.get(i);
            }
        }
        return maxA;
    }
}
