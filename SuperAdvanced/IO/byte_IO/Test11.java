package byte_IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test11 {
    public static void main(String[] args) throws FileNotFoundException {
        /*
        * jdk9:IO中捕获异常的方法
        *
        * */

        FileInputStream fis=new FileInputStream("C:\\Users\\Administrator\\Pictures\\手机相册\\401b9b99121984a46ec779dcda5759ec.mp4");
        FileOutputStream fos=new FileOutputStream("H:\\5e\\copy33.mp4");
        try(fis;fos){
            int len;
            byte[] bytes=new byte[1024*1024*5];
            while((len=fis.read(bytes))!=-1){
                fos.write(bytes,0,len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
