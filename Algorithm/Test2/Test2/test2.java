package Test2;

public class test2 {
    public static void main(String[] args){
        System.out.println(f(20));
    }
    public static int f(int floor){
        if(floor==1){
            return 1;
        }
        if(floor==2){
            return 2;
        }
        return f(floor-1)+f(floor-2);
    }
}
