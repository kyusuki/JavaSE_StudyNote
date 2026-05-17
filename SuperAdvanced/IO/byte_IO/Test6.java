package byte_IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test6 {
    public static void main(String[] args) throws IOException{
        long time1=System.currentTimeMillis();
        
        //拷贝文件
        FileInputStream fis=new FileInputStream("F:\\手机相册\\a6e892d61e1684a21a7eb4fafb44ffdf.mp4");
        FileOutputStream fos=new FileOutputStream("E:\\5e\\copy.mp4");
        //循环读取，边读边写
        int b;
        while((b=fis.read())!=-1){
            fos.write(b);
        }
        //关闭流，先开后关
        fos.close();
        fis.close();

        long time2=System.currentTimeMillis();
        System.out.println("耗时："+(time2-time1)+"ms");
    }
}
