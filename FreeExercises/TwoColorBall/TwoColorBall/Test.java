package TwoColorBall;
import java.util.Random;
import java.util.Scanner;
public class Test {
    private static Random r=new Random();
    private static Scanner sc=new Scanner(System.in);
    private static int one=0,two=0,three=0,four=0,five=0,six=0;
    public static void main(String[] args){
        boolean isStill=true;
        while(isStill){
            reset();
            int[] nums=new int[7];       
            System.out.print("玩家快做出你的选择吧(*^_^*) 1.可以自动选号哦 2.还可以手动选号哦 3.十连抽模式*^____^* 4.五十连抽模式(╯▔皿▔)╯ 5.一百连抽模式╰（‵□′）╯：");
            int choice1=sc.nextInt();
            System.out.println();
            switch(choice1){
                case 1:{
                    nums=autoSelect();
                    System.out.println("你的号码是：");
                    System.out.print("红球号码：");
                    for(int i=0;i<7;i++){
                        if(i<6){
                            System.out.print(nums[i]+" ");
                        }
                        else{
                            System.out.println("蓝球号码："+nums[i]);
                        }
                    }
                    System.out.println();
                    int[] openNum=getOpenNumber();
                    checkRight(nums, openNum);
                    System.out.println();
                    System.out.println("开奖号码是：");
                    printOpenNumber(openNum);
                    break;
                }
                case 2:{
                    nums=handSelect();
                    System.out.println();
                    System.out.println("你的号码是：");
                    System.out.print("红球号码：");
                    for(int i=0;i<7;i++){
                        if(i<6){
                            System.out.print(nums[i]+" ");
                        }
                        else{
                            System.out.println("蓝球号码："+nums[i]);
                        }
                    }
                    System.out.println();
                    int[] openNum=getOpenNumber();
                    checkRight(nums, openNum);
                    System.out.println();
                    System.out.println("开奖号码是：");
                    printOpenNumber(openNum);
                    break;
                }
                case 3:{
                    System.out.println("十连抽 启动！*^____^*");
                    int[][] tenGroups=new int[10][7]; //二维数组存10组
                    for(int i=0;i<10;i++){
                        tenGroups[i]=autoSelect();
                    }
                    int[] openNum=getOpenNumber();
                    for(int i=0;i<10;i++){
                        System.out.println("第"+(i+1)+"组号码：");
                        System.out.print("红球号码：");
                        for(int j=0;j<7;j++){
                            if(j<6){
                                System.out.print(tenGroups[i][j]+" ");
                            }
                            else{
                                System.out.println("蓝球号码："+tenGroups[i][j]);
                            }
                        }
                        checkRight(tenGroups[i], openNum);
                        System.out.println();
                        //System.out.println("一等奖："+one+" "+"二等奖："+two+" "+"三等奖："+three+" "+"四等奖："+four+" "+"五等奖："+five+" "+"六等奖："+six);
                    }
                    System.out.println("一等奖："+one+" "+"二等奖："+two+" "+"三等奖："+three+" "+"四等奖："+four+" "+"五等奖："+five+" "+"六等奖："+six);
                    break;
                }
                case 4:{
                    System.out.println("五十连抽 启动！！！(╯▔皿▔)");
                    int[][] fiftyGroups=new int[50][7]; //二维数组存10组
                    for(int i=0;i<50;i++){
                        fiftyGroups[i]=autoSelect();
                    }
                    int[] openNum=getOpenNumber();
                    for(int i=0;i<50;i++){
                        System.out.println("第"+(i+1)+"组号码：");
                        System.out.print("红球号码：");
                        for(int j=0;j<7;j++){
                            if(j<6){
                                System.out.print(fiftyGroups[i][j]+" ");
                            }
                            else{
                                System.out.println("蓝球号码："+fiftyGroups[i][j]);
                            }
                        }
                        checkRight(fiftyGroups[i], openNum);
                        System.out.println();
                        //System.out.println("一等奖："+one+" "+"二等奖："+two+" "+"三等奖："+three+" "+"四等奖："+four+" "+"五等奖："+five+" "+"六等奖："+six);
                    }
                    System.out.println("一等奖："+one+" "+"二等奖："+two+" "+"三等奖："+three+" "+"四等奖："+four+" "+"五等奖："+five+" "+"六等奖："+six);
                    break;
                }
                case 5:{
                    System.out.println("一百连抽 启动！！！╰（‵□′）╯");
                    int[][] hunGroups=new int[100][7]; //二维数组存10组
                    for(int i=0;i<100;i++){
                        hunGroups[i]=autoSelect();
                    }
                    int[] openNum=getOpenNumber();
                    for(int i=0;i<100;i++){
                        System.out.println("第"+(i+1)+"组号码：");
                        System.out.print("红球号码：");
                        for(int j=0;j<7;j++){
                            if(j<6){
                                System.out.print(hunGroups[i][j]+" ");
                            }
                            else{
                                System.out.println("蓝球号码："+hunGroups[i][j]);
                            }
                        }
                        checkRight(hunGroups[i], openNum);
                        System.out.println();
                        //System.out.println("一等奖："+one+" "+"二等奖："+two+" "+"三等奖："+three+" "+"四等奖："+four+" "+"五等奖："+five+" "+"六等奖："+six);
                    }
                    System.out.println("一等奖："+one+" "+"二等奖："+two+" "+"三等奖："+three+" "+"四等奖："+four+" "+"五等奖："+five+" "+"六等奖："+six);
                    break;
                }
                default:{
                    System.out.println("傻逼别乱选！");
                    System.exit(0);
                }
            }
            System.out.println();
            System.out.print("还要继续嘛，玩家？（1.还要和你玩 2.你真的要离开吗/(ㄒoㄒ)/~~）：");
            int stillChoice=sc.nextInt();
            if(stillChoice==2){
                isStill=false;
                System.out.println("玩家什么的，最讨厌了！！！");
            }
            else{
                System.out.println("最喜欢你了，玩家！！！");
                System.out.println();
            }
        }     
    }
    //自动选号
    private static int[] autoSelect(){
        //红球
        int[] red=new int[6];
        while(true){
            for(int i=0;i<6;i++){
                red[i]=r.nextInt(33)+1;
            }
            if(checkRepeat(red)){
                break;
            }
        }
        //蓝球
        int blue=r.nextInt(16)+1;
        //合并
        int[] result=new int[7];
        for(int i=0;i<7;i++){
            if(i<6){
                result[i]=red[i];
            }
            else{
                result[i]=blue;
            }
        }
        return result;
    }
    //手动选号
    private static int[] handSelect(){
        //红球
        int[] red=new int[6];
        while(true){
            System.out.print("请输入6个红球号码（1-33）：");
            for(int i=0;i<6;i++){
                red[i]=sc.nextInt();
            }
            if(checkRedFormat(red)){
                break;
            }
        }
        //蓝球
        int blue=0;
        while(true){
            System.out.print("请输入1个蓝球号码（1-16）：");
            blue=sc.nextInt();
            if(checkBlueFormat(blue)){
                break;
            }
        }
        //合并
        int[] result=new int[7];
        for(int i=0;i<7;i++){
            if(i<6){
                result[i]=red[i];     
            }
            else{
                result[i]=blue;
            }
        }
        return result;
    }
    //生成开奖号
    private static int[] getOpenNumber(){
        int[] openNum=new int[7];
        //目标红球
        int[] trueRed=new int[6];
        while(true){
            for(int i=0;i<6;i++){
                trueRed[i]=r.nextInt(33)+1;
            }
            if(checkRepeat(trueRed)){
                break;
            }
        }
        //目标蓝球
        int trueBlue=r.nextInt(16)+1;
        //合并
        for(int i=0;i<7;i++){
            if(i<6){
                openNum[i]=trueRed[i];
            }
            else{
                openNum[i]=trueBlue;
            }
        }
        return openNum;
    }
    //开奖公示
    public static void printOpenNumber(int[] openNum){
        System.out.print("红球号码：");
        for(int i=0;i<7;i++){
            if(i<6){
                System.out.print(openNum[i]+" ");
            }
            else{
                System.out.println("蓝球号码："+openNum[i]);
            }
        }
    }
    //中奖判定
    public static void checkRight(int[] userNum,int[] openNum){
        int redCount=0,blueCount=0;
        for(int i=0;i<6;i++){
            for(int j=0;j<6;j++){
                if(userNum[i]==openNum[j]){
                    redCount++;
                }
            }
        }
        if(userNum[6]==openNum[6]){
            blueCount++;
        }
        //中奖等级
        if(redCount==6&&blueCount==1){
            one++;
            System.out.println("恭喜你中了一等奖！");
        }
        else if(redCount==6&&blueCount==0){
            two++;
            System.out.println("恭喜你中了二等奖！");
        }
        else if(redCount==5&&blueCount==1){ 
            three++;
            System.out.println("恭喜你中了三等奖！");
        }
        else if((redCount==5)||(redCount==4&&blueCount==1)){
            four++;
            System.out.println("恭喜你中了四等奖！");
        }
        else if((redCount==4)||(redCount==3&&blueCount==1)){
            five++;
            System.out.println("恭喜你中了五等奖！");
        }
        else if(blueCount==1){
            six++;
            System.out.println("恭喜你中了六等奖！");
        }
        else{
            System.out.println("很遗憾，你没有中奖");
        }
    }
    //自动选号校验是否重复
    private static boolean checkRepeat(int[] nums){
        for(int i=0;i<6;i++){
            int index=r.nextInt(6);
            if(i!=index&&nums[i]==nums[index]){
                return false;
            }
        }
        return true;
    }
    //校验红球格式
    public static boolean checkRedFormat(int[] nums){
        if(nums.length!=6){
            System.out.println("红球号码格式错误！");
            return false;
        }
        for(int i=0;i<6;i++){
            if(nums[i]<1||nums[i]>33){
                System.out.println("红球号码格式错误！");
                return false;
            }
        }
        return true;
    }

    //校验蓝球格式
    public static boolean checkBlueFormat(int num){
        if(num<1||num>16){
            System.out.println("蓝球号码格式错误！");
            return false;
        }
        return true;
    }
    //初始统计
    public static void reset(){
        one=0;
        two=0;
        three=0;
        four=0;
        five=0;
        six=0;
    }
}
