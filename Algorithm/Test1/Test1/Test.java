package Test1;

import java.util.Arrays;
import java.util.Comparator;

public class Test {
    public static void main(String[] args){
        Girl g1=new Girl("abc",18,1.68);
        Girl g2=new Girl("def",19,1.65);
        Girl g3=new Girl("ghi",19,1.67);
        Girl[] girlArr={g1,g2,g3};
        //匿名内部类
        Arrays.sort(girlArr,new Comparator<Girl>() {
            @Override
            public int compare(Girl o1,Girl o2){
                double temp=o1.getAge()-o2.getAge();
                temp=temp==0?o1.getHeight()-o2.getHeight():temp;
                temp=temp==0?o1.getName().compareTo(o2.getName()):temp;
                if(temp>0){
                    return 1;
                }
                else if(temp<0){
                    return -1;
                }
                else{
                    return 0;
                }
            }
        });
        
        //Lambda表达式
        Arrays.sort(girlArr,(o1,o2)->{
            double temp=o1.getAge()-o2.getAge();
                temp=temp==0?o1.getHeight()-o2.getHeight():temp;
                temp=temp==0?o1.getName().compareTo(o2.getName()):temp;
                if(temp>0){
                    return 1;
                }
                else if(temp<0){
                    return -1;
                }
                else{
                    return 0;
                }
        });
        System.out.println(Arrays.toString(girlArr));
        
        /* 
         * for(int i=0;i<girlArr.length;i++){
         *     System.out.println(girlArr[i]);
         * }
         */
    }
}
