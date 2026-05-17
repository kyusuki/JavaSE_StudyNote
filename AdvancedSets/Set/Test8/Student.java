package Test8;

public class Student implements Comparable<Student>{
    private String name;
    private int age;
    private int ChineseScore;
    private int MathScore;
    private int EnglishScore;
    public Student(){}
    public Student(String name,int age,int ChineseScore,int MathScore,int EnglishScore){
        this.name=name;
        this.age=age;
        this.ChineseScore=ChineseScore;
        this.MathScore=MathScore;
        this.EnglishScore=EnglishScore;
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
    public int getChineseScore(){
        return ChineseScore;
    }
    public void setChineseScore(int ChineseScore){
        this.ChineseScore=ChineseScore;
    }
    public int getMathScore(){
        return MathScore;
    }
    public void setMathScore(int MathScore){
        this.MathScore=MathScore;
    }
    public int getEnglishScore(){
        return EnglishScore;
    }
    public void setEnglishScore(int EnglishScore){
        this.EnglishScore=EnglishScore;
    }
    public String toString(){
        return "Student[name="+name+",age="+age+",ChineseScore="+ChineseScore+",MathScore="+MathScore+",EnglishScore="+EnglishScore+"]";
    }
    @Override
    public int compareTo(Student o){
        int sum1=this.ChineseScore+this.MathScore+this.EnglishScore;
        int sum2=o.ChineseScore+o.MathScore+o.EnglishScore;
        int result1=sum1-sum2;
        if(result1==0){
            int result2=this.ChineseScore-o.ChineseScore;
            if(result2!=0){
                return result2;
            }
            if(result2==0){
                int result3=this.MathScore-o.MathScore;
                if(result3!=0){
                    return result3;
                }
                if(result3==0){
                    int result4=this.EnglishScore-o.EnglishScore;
                    if(result4!=0){
                        return result4;
                    }
                    if(result4==0){
                        return this.getAge()-o.getAge();
                    }
                }
            }
        }
        return result1;
    }
}
