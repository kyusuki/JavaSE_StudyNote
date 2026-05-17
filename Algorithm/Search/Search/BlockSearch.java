package Search;

public class BlockSearch {
    public static void main(String[] args){
        int[] arr={16,5,9,12,21,18,
                   32,23,37,26,45,34,
                   50,48,61,52,73,66};
        //创建块的对象
        Block b1=new Block(21,0,5);
        Block b2=new Block(45,6,11);
        Block b3=new Block(73,12,17);
        //创建块组存放块
        Block[] blockArr={b1,b2,b3};
        //调用方法
        int index=getIndex(blockArr,arr,26);
        System.out.println(index);
    }
    //查找索引
    public static int getIndex(Block[] blockArr,int[] arr,int target){
        int blockIndex=getBlockIndex(blockArr,target);
        for(int i=blockArr[blockIndex].getStartIndex();i<blockArr[blockIndex].getEndIndex();i++){
            if(arr[i]==target){
                return i;
            }
        }
        return -1;
    }
    //确定target位于哪个块中
    public static int getBlockIndex(Block[] blockArr,int target){
        for(int i=0;i<blockArr.length;i++){
            Block block=blockArr[i];
            if(target<=block.getMax()){
                return i;
            }
        }
        return -1;
    }
}
class Block {
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
