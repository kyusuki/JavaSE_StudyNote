package taskThree;

public class stringbuilder3 {
    public static void main(String[] args){
        StringBuilder sb=new StringBuilder();
        System.out.println(sb.capacity()); //16
        System.out.println(sb.length()); //0
        
        sb.append("abc");
        System.out.println(sb.capacity()); //16
        System.out.println(sb.length()); //3

        sb.append("defghijklmnopqrstuvwxyz");
        System.out.println(sb.capacity()); //34
        System.out.println(sb.length()); //26
    }
}
