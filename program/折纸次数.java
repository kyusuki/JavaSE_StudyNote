public class 折纸次数 {
    public static void main(String[] args){
        int count=0;
        double h=0.2;
        while(h<8848.0){
            h=h*2.0;
            count++;
        }
        System.out.println(count);
    }
}
