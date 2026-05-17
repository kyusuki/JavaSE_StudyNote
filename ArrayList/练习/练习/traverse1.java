package 练习;
import java.util.ArrayList;
import java.util.StringJoiner;
public class traverse1 {
    public static void main(String[] args){
        ArrayList<String> list=new ArrayList<>();
        list.add("点赞");
        list.add("投币");
        list.add("收藏");
        StringJoiner sj=new StringJoiner(",","[","]");
        for(int i=0;i<list.size();i++){
            String s=list.get(i);
            sj.add(s);
        }
        System.out.println(sj.toString());
    }
}
