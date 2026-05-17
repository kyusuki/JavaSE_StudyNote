package taskThree;
import java.util.StringJoiner;
public class stringjoiner {
    public static void main(String[] args){
        StringJoiner sj=new StringJoiner("---");
        sj.add("aaa").add("bbb").add("ccc");
        System.out.println(sj);
    }
}
