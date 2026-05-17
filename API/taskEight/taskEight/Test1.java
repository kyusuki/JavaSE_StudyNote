package taskEight;

public class Test1 {
    public static void main(String[] args){
        String str="1234567890";
        boolean result=str.matches("[1-9]\\d{5,19}"); //true
        System.out.println(result);
        System.out.println("\"");
        System.out.println("大傻bi".matches("....")); //true
        System.out.println("9".matches("\\d")); //true
        System.out.println("9".matches("\\D")); //false
        System.out.println("aaa111".matches("\\w{6,}")); //true
        System.out.println("bbb222".matches("\\w{7,}")); //false
    }
}