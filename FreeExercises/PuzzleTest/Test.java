import java.util.Random;
public class Test {
    public static void main(String[] args){
        int[] tempArr={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        Random r=new Random();
        for(int i=0;i<tempArr.length;i++){
            int index=r.nextInt(tempArr.length)+1;
            int temp=tempArr[i];
            tempArr[i]=tempArr[index];
            tempArr[index]=temp;
        }
        int[][] arr=new int[4][4];
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                arr[i][j]=tempArr[4*i+j];
            }
        }
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
