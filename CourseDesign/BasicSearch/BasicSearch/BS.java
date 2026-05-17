package BasicSearch;

import java.util.Scanner;
import java.util.Set;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class BS {
    public static void main(String[] args){
        basicSearchTest(new Scanner(System.in));
    }
    static ArrayList<Integer> countList=new ArrayList<>();
    public static void basicSearchTest(Scanner sc){
        //Scanner sc=new Scanner(System.in);
        Random r=new Random();
        System.out.print("请输入元素个数：");
        int n=sc.nextInt();
        Set<Integer> set=new HashSet<>();
        while(set.size()<n){
            set.add(r.nextInt(n)+1);
        }
        ArrayList<Integer> list=new ArrayList<>(set);
        Collections.shuffle(list);
        System.out.println("随机生成数组为："+list);
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=list.get(i);
        }
        System.out.print("请输入目标元素：");
        int target=sc.nextInt();
        int index=basicSearch(arr,target,countList);
        if(index!=-1){
            System.out.println("目标元素索引为："+index);
            System.out.println("查找次数为："+countList.get(countList.size()-1));
        }
        else{
            System.out.println("目标元素不存在");
        }
        System.out.println();
        System.out.println("基本查找平均耗时："+avgTime(arr)+"纳秒");
        //sc.close();
    }
    //基本查找
    public static int basicSearch(int[] arr,int target,ArrayList<Integer> countList){
        int count=0;
        for(int i=0;i<arr.length;i++){
            count++;
            if(arr[i]==target){
                countList.add(count);
                return i;
            }
        }
        return -1;
    }
    //计算平均查找时间
    public static double avgTime(int[] arr){
        double sum=0;
        for(int i=0;i<arr.length;i++){
            long time1=System.nanoTime();
            basicSearch(arr,arr[i],countList);
            long time2=System.nanoTime();
            sum+=time2-time1;
        }
        return sum/arr.length;
    }
}
    