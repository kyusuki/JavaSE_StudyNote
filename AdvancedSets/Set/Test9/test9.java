package Test9;

import java.util.Comparator;
import java.util.TreeSet;

public class test9 {
    public static void main(String[] args){
        TreeSet<Student> ts=new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1,Student o2){
                int sum1=o1.getChineseScore()+o1.getMathScore()+o1.getEnglishScore();
                int sum2=o2.getChineseScore()+o2.getMathScore()+o2.getEnglishScore();
                int result1=sum1-sum2;
                if(result1==0){
                    int result2=o1.getChineseScore()-o2.getChineseScore();
                    if(result2!=0){
                        return result2;
                    }
                    if(result2==0){
                        int result3=o1.getMathScore()-o2.getMathScore();
                        if(result3!=0){
                            return result3;
                        }
                        if(result3==0){
                            int result4=o1.getEnglishScore()-o2.getEnglishScore();
                            if(result4!=0){
                                return result4;
                            }
                            if(result4==0){
                                int result5=o1.getAge()-o2.getAge();
                                if(result5!=0){
                                    return result5;
                                }
                                if(result5==0){
                                    return o1.getName().compareTo(o2.getName());
                                }
                            }
                        }
                    }
                }
                return result1;
            }
        });
        ts.add(new Student("zhangsan",23,90,99,50));
        ts.add(new Student("lisi",24,90,98,50));
        ts.add(new Student("wangwu",25,95,100,30));
        ts.add(new Student("zhaoliu",26,60,99,70));
        ts.add(new Student("qianqi",26,70,80,70));
        for(Student s:ts){
            System.out.println(s);
        }
    }
}
