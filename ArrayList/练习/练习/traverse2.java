package 练习;
import java.util.ArrayList;
import java.util.StringJoiner;
public class traverse2 {
    public static void main(String[] args){
        ArrayList<Integer> list=new ArrayList<>();
        list.add(12);
        list.add(23);
        list.add(34);
        StringJoiner sj=new StringJoiner(",","[","]");
        for(int i=0;i<list.size();i++){
            int num=list.get(i);
            sj.add(Integer.toString(num));
        }
        System.out.println(sj.toString());
    }
}
