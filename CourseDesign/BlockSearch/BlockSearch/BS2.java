package BlockSearch;

import java.util.Arrays;
import java.util.Scanner;

public class BS2 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int[] arr={17, 23, 19, 21, 15,
                   8, 3, 12, 5, 10,
                   29, 35, 27, 31, 33
                  };
        System.out.println("数组元素为："+Arrays.toString(arr));
        Block[] blockArr=new Block[3];
        blockArr[0]=new Block(17,23,0,4);
        blockArr[1]=new Block(3,12,5,9);
        blockArr[2]=new Block(27,35,10,14);
        System.out.print("请输入目标元素：");
        int target=sc.nextInt();
        int result=blockSearch(blockArr, arr, target);
        if(result!=-1){
            System.out.println("目标元素索引为："+result);
        }
        else{
            System.out.println("目标元素不存在");
        }
        sc.close();
    }
    //找到目标所在快
    public static int blockIndex(Block[] blockArr,int target){
        for(int i=0;i<blockArr.length;i++){
            if(target>=blockArr[i].getMin()&&target<=blockArr[i].getMax()){
                return i;
            }
        }
        return -1;
    }
    //块间无序分块查找
    public static int blockSearch(Block[] blockArr,int[] arr,int target){
        int index=blockIndex(blockArr,target);
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
}
class Block{
    private int max;
    private int min;
    private int startIndex;
    private int endIndex;
    public Block(){}
    public Block(int min,int max,int startIndex,int endIndex){
        this.min=min;
        this.max=max;
        this.startIndex=startIndex;
        this.endIndex=endIndex;
    }
    public int getMin(){
        return min;
    }
    public void setMin(int min){
        this.min=min;
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
