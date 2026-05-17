package byte_IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test8 {
    public static void main(String[] args) throws IOException{
        //拷贝较大文件时，建议使用缓冲区
        
        //创建字符输入流和字符输出流对象
        FileInputStream fis=new FileInputStream("G:\\xunlei\\00904\\A\\0904a系统显卡升级备份\\00904\\886\\8\\668\\艾悠_前戲1.mp4");
        FileOutputStream fos=new FileOutputStream("E:\\5e\\copyy.mp4");
        //循环读取，边读边写，缓存区大小为5KB
        int len;
        byte[] bt=new byte[1024*5];
        while((len=fis.read(bt))!=-1){
            fos.write(bt,0,len);
        }
        //关闭流
        fos.close();
        fis.close();
    }
}
