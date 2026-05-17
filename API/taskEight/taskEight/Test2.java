package taskEight;
import java.util.Scanner;
public class Test2 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String phone=sc.next();
        String stand=sc.next();
        String email=sc.next();
        String id=sc.next();
        System.out.println(phone.matches("1[3-9]\\d{9}"));
        System.out.println(stand.matches("0\\d{2,4}-?[1-9]\\d{3,9}"));
        System.out.println(email.matches("\\w+@[\\w&&[^_]]{2,6}(\\.[a-zA-Z]{2,3}){1,2}"));
        System.out.println(id.matches("[1-9]\\d{16}(\\d|X|x)"));
        sc.close();
    }
}
