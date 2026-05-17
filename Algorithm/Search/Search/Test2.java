package Search;

public class Test2 {
    public static void main(String[] args){
        int[] arr={27,22,30,40,36,
                   13,19,16,20,
                   7,10,
                   43,50,48};
        Block b1=new Block(22,40,0,4);
        Block b2=new Block(13,20,5,8);
        Block b3=new Block(7,10,9,10);
        Block b4=new Block(43,50,11,13);
        Block[] blockArr={b1,b2,b3,b4};
        int index=getIndex(blockArr, arr, 19);
        System.out.println(index);
    }
    public static int getIndex(Block[] blockArr,int[] arr,int target){
        int blockIndex=getBlockIndex(blockArr, target);
        for(int i=blockArr[blockIndex].getStartIndex();i<=blockArr[blockIndex].getEndIndex();i++){
            if(arr[i]==target){
                return i;
            }
        }
        return -1;
    }
    public static int getBlockIndex(Block[] blockArr,int target){
        for(int i=0;i<blockArr.length;i++){
            Block block=blockArr[i];
            if(target>=block.getMin()&&target<=block.getMax()){
                return i;
            }
        }
        return -1;
    }
}
class Block {
    private int min;
    private int max;
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
