/*import java.util.Scanner;
public class 二维数组 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int[][] arr1={{1,2,3},{4,5,6},{7,8,9}};
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr1[i].length;j++){
                System.out.print(arr1[i][j]+" ");
                //if((j+1)%3==0){
                //    System.out.println();
                //}
            }
            System.out.println();
        }
        int[][] arr2=new int[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                arr2[i][j]=sc.nextInt();
            }
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(arr2[i][j]+" ");
                if((j+1)%3==0){
                    System.out.println();
                }
            }
        }
        sc.close();
    }
}*/

import java.util.Scanner;
public class 二维数组{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int[][] arr=new int[4][3];
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        int sum1=0;
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                sum1+=arr[i][j];
            }
        }
        System.out.println("总销售额为："+sum1);
        for(int i=0;i<4;i++){
            int sum2=0;
            for(int j=0;j<3;j++){
                sum2+=arr[i][j];
            }
            System.out.println("第"+(i+1)+"季度总销售额为："+sum2);
        }
    }
}