import java.util.Scanner;
public class 数组遍历 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a[]=new int[5];
        for(int i=0;i<5;i++){
            a[i]=sc.nextInt();
        }
        int num=sc.nextInt();
        int index=f(a,num);
        if(index==-1){
            System.out.println("该数不存在");
        }
        else{
            System.out.println("该数下标为："+index);
        }
        sc.close();
    }
    public static int f(int[] a,int num){
        for(int i=0;i<a.length;i++){
            if(a[i]==num){
                return i;
            }
        }
        return -1;
    }
}
