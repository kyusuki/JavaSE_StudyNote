package BlockSearch;

import java.util.Arrays;
import java.util.Scanner;

public class BS1 {
    public static void main(String[] args){
        blockSearchTest(new Scanner(System.in));
    }
    public static void blockSearchTest(Scanner sc){
        //Scanner sc=new Scanner(System.in);
        int[] arr = {5, 9, 3, 7, 18, 12, 15, 20};
        System.out.println("数组元素为："+Arrays.toString(arr));
        Block b1 = new Block(9, 0, 3);
        Block b2 = new Block(20, 4, 7);
        Block[] blockArr = {b1, b2};
        System.out.print("请输入目标元素：");
        int target=sc.nextInt();
        int result=blockSearch(blockArr, arr, target);
        if(result!=-1){
            System.out.println("目标元素索引为："+result);
        }
        else{
            System.out.println("目标元素不存在");
        }
        System.out.println();
        System.out.println("平均查找时间为："+avgTime(arr,blockArr,target)+"纳秒");
        //sc.close();
    }
    //找到目标所在快
    public static int blockIndex(Block[] blockArr,int target){
        for(int i=0;i<blockArr.length;i++){
            int max=blockArr[i].getMax();
            if(target<=max){
                return i;
            }
        }
        return -1;
    }
    //块间有序分块查找
    public static int blockSearch(Block[] blockArr,int[] arr,int target){
        int index=blockIndex(blockArr, target);
        if(index==-1){
            return -1;
        }
        for(int i=blockArr[index].getStartIndex();
            i<=blockArr[index].getEndIndex();i++){
            if(arr[i]==target){
                return i;
            }
        }
        return -1;
    }
    //计算平均查找时间
    public static double avgTime(int[] arr,Block[] blockArr,int target){
        double sum=0;
        for(int i=0;i<arr.length;i++){
            long time1=System.nanoTime();
            blockIndex(blockArr,target);
            blockSearch(blockArr,arr,arr[i]);
            long time2=System.nanoTime();
            sum+=time2-time1;
        }
        return sum/arr.length;
    }
}
class Block{
    private int max;
    private int startIndex;
    private int endIndex;
    public Block(){}
    public Block(int max,int startIndex,int endIndex){
        this.max=max;
        this.startIndex=startIndex;
        this.endIndex=endIndex;
    }
    public int getMax(){
        return max;
    }
    public void setMax(int max){
        this.max=max;
    }
    public int getStartIndex(){
        return startIndex;
    }
    public void setStartIndex(int startIndex){
        this.startIndex=startIndex;
    }
    public int getEndIndex(){
        return endIndex;
    }
    public void setEndIndex(int endIndex){
        this.endIndex=endIndex;
    }
}
/* 长度8
int[] arr = {5, 9, 3, 7, 18, 12, 15, 20};
        System.out.println("数组元素为："+Arrays.toString(arr));
        Block b1 = new Block(9, 0, 3);
        Block b2 = new Block(20, 4, 7);
        Block[] blockArr = {b1, b2};
*/
/* 长度12
int[] arr={7,2,8,3,18,13,15,20,29,23,27,25};
        System.out.println("数组元素为："+Arrays.toString(arr));
        Block b1=new Block(8,0,3);
        Block b2=new Block(20,4,7);
        Block b3=new Block(29,8,11);
        Block[] blockArr={b1,b2,b3};
*/
/* 长度10
int[] arr = {11, 8, 14, 9, 12, 25, 21, 28, 23, 26};
        System.out.println("数组元素为："+Arrays.toString(arr));
        Block b1 = new Block(14, 0, 2);
        Block b2 = new Block(28, 3, 6);
        Block b3 = new Block(26, 7, 9);
        Block[] blockArr = {b1, b2, b3};
*/
/* 长度15
int[] arr = {7, 13, 9, 15, 11, 22, 18, 25, 20, 27, 34, 30, 36, 32, 38};
        System.out.println("数组元素为："+Arrays.toString(arr));
        Block b1 = new Block(15, 0, 3);
        Block b2 = new Block(27, 4, 7);
        Block b3 = new Block(36, 8, 11);
        Block b4 = new Block(38, 12, 14);
        Block[] blockArr = {b1, b2, b3, b4};
*/
/* 长度20
int[] arr = {4, 8, 6, 10, 7, 9, 5, 11, 3, 12, 18, 15, 20, 17, 22, 19, 24, 21, 26, 23};
        System.out.println("数组元素为："+Arrays.toString(arr));
        Block b1 = new Block(10, 0, 3);
        Block b2 = new Block(12, 4, 7);
        Block b3 = new Block(20, 8, 11);
        Block b4 = new Block(24, 12, 15);
        Block b5 = new Block(26, 16, 19);
        Block[] blockArr = {b1, b2, b3, b4, b5};
*/
/* 长度24
int[] arr = {15, 11, 17, 13, 19, 16, 28, 24, 30, 26, 32, 29, 41, 37, 43, 39, 45, 42, 54, 50, 56, 52, 58, 55};
        System.out.println("数组元素为："+Arrays.toString(arr));
        Block b1 = new Block(19, 0, 3);
        Block b2 = new Block(19, 4, 7);
        Block b2_correct = new Block(28, 4, 7);
        Block b3 = new Block(32, 8, 11);
        Block b4 = new Block(45, 12, 15);
        Block b5 = new Block(45, 16, 19);
        Block b5_correct = new Block(54, 16, 19);
        Block b6 = new Block(58, 20, 23);
        Block[] blockArr = {b1, b2_correct, b3, b4, b5_correct, b6};
*/
/* 长度30
int[] arr = {9, 5, 11, 7, 13, 8, 15, 10, 22, 18, 24, 20, 26, 22, 28, 24, 35, 31, 37, 33, 39, 35, 41, 37, 48, 44, 50, 46, 52, 48};
        System.out.println("数组元素为："+Arrays.toString(arr));
        Block b1 = new Block(15, 0, 3);
        Block b2 = new Block(15, 4, 7);
        Block b3 = new Block(28, 8, 11);
        Block b4 = new Block(28, 12, 15);
        Block b5 = new Block(41, 16, 19);
        Block b6 = new Block(41, 20, 23);
        Block b7 = new Block(52, 24, 27);
        Block b7_correct = new Block(50, 24, 27);
        Block b8 = new Block(52, 28, 29);
        Block[] blockArr = {b1, b2, b3, b4, b5, b6, b7_correct, b8};
*/
