package FibonacciSearch;

import java.util.Scanner;
import java.util.Set;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class FS {
    static ArrayList<Integer> countList=new ArrayList<>();
    public static void main(String[] args){
        fibonacciSearchTest(new Scanner(System.in));
    }
    public static void fibonacciSearchTest(Scanner sc){
        //Scanner sc=new Scanner(System.in);
        Random r=new Random();
        System.out.print("请输入元素个数：");
        int n=sc.nextInt();
        Set<Integer> set=new HashSet<>();
        while(set.size()<n){
            set.add(r.nextInt(n)+1);
        }
        ArrayList<Integer> list=new ArrayList<>(set);
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=list.get(i);
        }
        Arrays.sort(arr);
        System.out.println("随机数组元素为："+Arrays.toString(arr));
        System.out.print("请输入目标元素：");
        int target=sc.nextInt();
        int index=fibonacciSearch(arr,target,countList);
        if(index!=-1){
            System.out.println("目标元素索引为："+index);
            System.out.println("查找次数为："+countList.get(countList.size()-1));
        }
        else{
            System.out.println("目标元素不存在");
        }
        System.out.println();
        System.out.println("斐波那契查找平均耗时："+avgTime(arr)+"纳秒");
        //sc.close();
    }
    //构建斐波那契数列
    public static int[] fibonacciArr(){
        int[] f=new int[100];
        f[0]=1;
        f[1]=1;
        for(int i=2;i<100;i++){
            f[i]=f[i-1]+f[i-2];
        }
        return f;
    }
    //斐波那契查找
    public static int fibonacciSearch(int[] arr,int target,ArrayList<Integer> countList){
        int[] f=fibonacciArr();
        int min=0;
        int max=arr.length-1;
        int k=0; //记录斐波那契数列的下标
        int count=0;
        while(max>f[k]-1){
            k++; //目的是找打第一个大于等于数组长度的斐波那契数
        }
        int[] temp=Arrays.copyOf(arr,f[k]); //将数组扩展到斐波那契数列的长度
        for(int i=max+1;i<f[k];i++){
            temp[i]=arr[max]; //将扩展后的数组用最后一个元素填充
        }
        while(min<=max){
            count++;
            int mid=min+f[k-1]-1;
            if(target<temp[mid]){
                max=mid-1;
                k--; //继续查找左半边的斐波那契数，新的查找长度为f[k-1]-1
            }
            else if(target>temp[mid]){
                min=mid+1;
                k-=2; //继续查找右半边的斐波那契数，新的查找长度为f[k-2]-1
            }
            else{
                countList.add(count);
                return mid;
            }
        }
        return -1;
    }
    //计算平均查找时间
    public static double avgTime(int[] arr){
        double sum=0;
        for(int i=0;i<arr.length;i++){
            long time1=System.nanoTime();
            fibonacciSearch(arr,arr[i],countList);
            long time2=System.nanoTime();
            sum+=time2-time1;
        }
        return sum/arr.length;
    }
}
