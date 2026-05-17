package taskEight;

public class Test9 {
    public static void main(String[] args){
        /*
         * 需求：替换"我要学学编编编编程程程程程"为"我要学编程"
         */
        String str="我要学学编编编编程程程程程";
        String regex=str.replaceAll("(.)\\1+","$1");
        System.out.println(regex);
    }
}
