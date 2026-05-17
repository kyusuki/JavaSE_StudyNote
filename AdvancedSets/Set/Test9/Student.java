package Test9;

public class Student {
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
}
