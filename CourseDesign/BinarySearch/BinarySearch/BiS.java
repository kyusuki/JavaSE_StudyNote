package BinarySearch;

import java.util.Scanner;
import java.util.Set;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class BiS {
    public static void main(String[] args){
        binarySearchTest(new Scanner(System.in));
    }
    static ArrayList<Integer> countList=new ArrayList<>();
    public static void binarySearchTest(Scanner sc){
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
        sort(arr);
        System.out.println("随机数组元素为："+Arrays.toString(arr));
        System.out.print("请输入目标元素：");
        int target=sc.nextInt();
        int index=binarySearch(arr,target,countList);
        if(index!=-1){
            System.out.println("目标元素索引为："+index);
            System.out.println("查找次数为："+countList.get(countList.size()-1));
        }
        else{
            System.out.println("目标元素不存在");
        }
        System.out.println();
        System.out.println("二分查找平均时间为："+avgTime(arr)+"纳秒");
        //sc.close();
    }
    //排序
    public static void sort(int[] arr){
        Arrays.sort(arr);
    }
    //二分查找
    public static int binarySearch(int[] arr,int target,ArrayList<Integer> countList){
        int min=0;
        int max=arr.length-1;
        int count=0;
        while(min<=max){
            count++;
            int mid=min+(max-min)/2;
            if(arr[mid]<target){
                min=mid+1;
            }
            else if(arr[mid]>target){
                max=mid-1;
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
            binarySearch(arr,arr[i],countList);
            long time2=System.nanoTime();
            sum+=time2-time1;
        }
        return sum/arr.length;
    }
}
