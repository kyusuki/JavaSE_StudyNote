public class 短路符 {
    public static void main(String[] args){
        boolean a=true;
        boolean b=false;
        boolean c=a&&b;
        boolean d=a||b;
        boolean e=!a;
        boolean f=(!a)^b;
        System.out.println(c); //false
        System.out.println(d); //true 
        System.out.println(e); //false
        System.out.println(f); //false
    }
}
