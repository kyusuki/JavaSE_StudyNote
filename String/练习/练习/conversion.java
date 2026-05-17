package 练习;
import java.util.Scanner;
public class conversion {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int money;
        while(true){
            System.out.println("请输入金额");
            money=sc.nextInt(); //2135
            if(money>=0&&money<=999999){
                break;
            }
            else{
                System.out.println("金额错误");
            }
        }
        String moneyStr="";
        System.out.println("你输入的金额是"+money);
        //int count=0;
        //int temp1=money;
        while(true){
            int temp=money%10;
            String s=toConversion(temp);
            moneyStr=s+moneyStr; //贰壹叁伍
            money/=10;
            //count++;
            if(money==0){
                break;
            }
        }
        int count=7-moneyStr.length();
        for(int i=0;i<count;i++){
            moneyStr="零"+moneyStr; //零零零贰壹叁伍
        }
        String[] arr={"佰","拾","万","仟","佰","拾","元"};
        String result="";
        for(int i=0;i<moneyStr.length();i++){
            char c=moneyStr.charAt(i); //{零,零,零,贰,壹,叁,伍}
            result=result+c+arr[i];
        }
        System.out.println(result);
        /*int n=count;
        int[] arr2=new int[count];
        String[] arr3={"","拾","佰","仟","万","拾万"};
        while(count>0){
            int temp2=temp1%10;
            arr2[count-1]=temp2;
            temp1/=10;
            count--;
        } //arr2={2,1,3,5}
        for(int i=0;i<n/2;i++){
            int temp3=arr2[n-i-1];
            arr2[n-i-1]=arr2[i];
            arr2[i]=temp3;
        } //arr2={5,3,1,2}
        String result="";
        for(int i=0;i<n;i++){
            result+=toConversion(arr2[i]); //伍叁壹贰
        }
        String str=reverse(result);
        char[] arr4=str.toCharArray(); //{伍,叁,壹,贰}
        for(int i=0;i<str.length();i++){
            System.out.print(arr4[i]+arr3[i]);
        }
        System.out.print("元");*/
        sc.close();
    }
    public static String toConversion(int num){
        String[] arr1={"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
        return arr1[num];
    }
    /*public static String reverse(String str){
        char[] arr=new char[str.length()];
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            arr[i]=c;
        }
        for(int i=0;i<arr.length/2;i++){
            char temp=arr[i];
            arr[i]=arr[arr.length-i-1];
            arr[arr.length-i-1]=temp;
        }
        String s="";
        for(int i=0;i<arr.length;i++){
            s=s+arr[i];
        }
        return s;
    }*/
}
