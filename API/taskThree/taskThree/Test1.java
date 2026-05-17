package taskThree;

public class Test1 {
    public static void main(String[] args){
        //1.获取Runtime对象
        //Runtime r=Runtime.getRuntime();
        
        //2.停止虚拟机
        //Runtime.getRuntime().exit(0); //退出虚拟机，是System.exit(0);的底层代码
        
        //3.获取本机CPU线程数
        System.out.println(Runtime.getRuntime().availableProcessors());

        //4.能从系统中获取的最大内存
        System.out.println(Runtime.getRuntime().maxMemory()/1024/1024+"MB");

        //5.已经使用的内存
        System.out.println(Runtime.getRuntime().totalMemory()/1024/1024+"MB");

        //6.空闲内存
        System.out.println(Runtime.getRuntime().freeMemory()/1024/1024+"MB");

        //7.运行cmd命令
        //Runtime.getRuntime().exec("shutdown -s -t 0"); //立即关机
    }
}
