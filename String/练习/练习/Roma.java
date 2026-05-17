package 练习;
import java.util.Scanner;
import java.util.StringJoiner;
public class Roma {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s="";
        boolean flag=false;
        while(true){
            System.out.println("请输入数字");
            s=sc.nextLine();
            if(s.length()<=9){
                flag=true;
                for(int i=0;i<s.length();i++){
                    char c=s.charAt(i);
                    if(c<='0'||c>'9'){
                        System.out.println("输入错误");
                        flag=false;
                        break;
                    }
                }
                if(flag){
                    break;
                }
            }
            else{
                System.out.println("输入错误");
                continue;
            }
        }
        int[] arr=new int[s.length()];
        for(int i=0;i<s.length();i++){
            arr[i]=Integer.parseInt(s.substring(i,i+1));
        }
        System.out.println(f(arr));
        sc.close();
    }
    public static String f(int[] arr){
        StringJoiner sj=new StringJoiner(",");
        char[] ch={'Ⅰ','Ⅱ','Ⅲ','Ⅳ','Ⅴ','Ⅵ','Ⅶ','Ⅷ','Ⅸ'};
        for(int i=0;i<arr.length;i++){
            sj.add(ch[arr[i]-1]+"");
        }
        return sj.toString();
    }
}

/*
import java.util.Scanner;
import java.util.StringJoiner;
public class Roma{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str="";
        while(true){
            System.out.println("请输入数字");
            str=sc.nextLine();
            boolean flag=f1(str);
            if(flag){
                break;
            }
            else{
                System.out.println("输入错误");
            }
        }
        StringJoiner sj=new StringJoiner(",");
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            sj.add(f2(c)+"");
        }
        System.out.println(sj.toString());
        sc.close();
    }
    //判断方法
    public static boolean f1(String s){
        if(s.length()<=9){
            return true;
        }
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)<'0'||s.charAt(i)>'9'){
                return false;
            }
            return true;
        }
        return false;
    }
    //转换方法
    public static String f2(char num){
        String str=switch(num){
            case '0'->"";
            case '1'->"Ⅰ";
            case '2'->"Ⅱ";
            case '3'->"Ⅲ";
            case '4'->"Ⅳ";
            case '5'->"Ⅴ";
            case '6'->"Ⅵ";
            case '7'->"Ⅶ";
            case '8'->"Ⅷ";
            case '9'->"Ⅸ";
            default->"";
        };
        return str;
    }
}
*/