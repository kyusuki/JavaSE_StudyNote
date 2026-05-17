import java.util.Scanner;
import java.util.Random;
public class 双色球系统 {
    public static void main(String[] args){
        //1.生成开奖号码
        int[] winRed=makeRedBall();
        int winBlue=makeBlueBall();
        //2.用户投注
        int[] myRed=inputRed();
        int myBlue=inputBlue();
        //3.检查中奖
        int level=checkWin(myRed,myBlue,winRed,winBlue);
        //4.输出结果
        System.out.println("\n===开奖结果===");
        System.out.print("红球：");
        printArr(winRed);
        System.out.println("蓝球："+winBlue);
        System.out.println("\n===你的投注===");
        System.out.print("红球：");
        printArr(myRed);
        System.out.println("蓝球："+myBlue);
        System.out.println("\n===开奖结果===");
        if(level==0){
            System.out.println("很遗憾，你没有中奖");
        }
        else{
            System.out.println("恭喜你中了"+level+"等奖");
        }
    }
    //生成红球
    public static int[] makeRedBall(){
        int[] red=new int[6];
        Random rand=new Random();
        for(int i=0;i<6;){
            int num=rand.nextInt(33)+1;
            if(!isRepeat(red,num,i)){
                red[i]=num;
                i++;
            }
        }
        return red;
    }
    //生成蓝球
    public static int makeBlueBall(){
        Random rand=new Random();
        return rand.nextInt(16)+1;
    }
    //用户投注红球
    public static int[] inputRed(){
        Scanner sc=new Scanner(System.in);
        int[] red=new int[6];
        System.out.println("===请输入6个红球(1-33)：===");
        for(int i=0;i<6;){
            System.out.print("第"+(i+1)+"个红球：");
            int num=sc.nextInt();
            if(num<1||num>33){
                System.out.println("输入范围错误，请重新输入");
                continue;
            }
            if(isRepeat(red,num,i)){
                System.out.println("红球已存在，请重新输入");
                continue;
            }
            red[i]=num;
            i++;
        }
        return red;
    }
    //用户投注蓝球
    public static int inputBlue(){
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.print("===请输入1个蓝球(1-16)：===");
            int num=sc.nextInt();
            if(num>=1&&num<=16){
                return num;
            }
            else{
                System.out.println("输入范围错误，请重新输入");
            }
        }
    }
    //检查红球是否重复
    public static boolean isRepeat(int[] arr,int target,int len){
        for(int i=0;i<len;i++){
            if(arr[i]==target){
                return true;
            }
        }
        return false;
    }
    //打印数组
    public static void printArr(int[] arr){
        for(int num:arr){
            System.out.print(num+" ");
        }
        System.out.println();
    }
    //检查中奖
    public static int checkWin(int[] myRed,int myBlue,int[] winRed,int winBlue){
        int redHit=0;
        for(int my:myRed){
            for(int win:winRed){
                if(my==win){
                    redHit++;
                    break;
                }
            }
        }
        boolean blueHit=(myBlue==winBlue);
        if(redHit==6&&blueHit){
            return 1;
        }
        if(redHit==6&&!blueHit){
            return 2;
        }
        if(redHit==5&&blueHit){
            return 3;
        }
        if(redHit==5||(redHit==4&&blueHit)){
            return 4;
        }
        if(blueHit||redHit==3){
            return 6;
        }
        return 0;
    }
}
