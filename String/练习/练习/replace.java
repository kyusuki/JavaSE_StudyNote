package 练习;
import java.util.Scanner;
public class replace {
    public static void main(String[] args){
        //String replace(char oldChar,char newChar) 替换，只有返回值才是替换后的结果
        
        /*String talk="你tm就是个菜鸡，cnm";
        String result1=talk.replace("tm","**");
        String result2=result1.replace("cnm","***");
        System.out.println(result2); //你**就是个菜鸡，*** */
        Scanner sc=new Scanner(System.in);
        System.out.println("你想说啥");
        String talk=sc.nextLine();
        String[] arr={"TMD","CNM","SB","MLGB"};
        for(int i=0;i<arr.length;i++){
            talk=talk.replace(arr[i],"*");
        }
        System.out.println(talk);
        sc.close();
    }
}
