package byte_IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test9 {
    public static void main(String[] args){
        FileInputStream fis=null;
        FileOutputStream fos=null;
        try{
            fis=new FileInputStream("F:\\手机相册\\a6e892d61e1684a21a7eb4fafb44ffdf.mp4");
            fos=new FileOutputStream("E:\\5e\\copy.mp4");
            int b;
            while((b=fis.read())!=-1){
                fos.write(b);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                fos.close();
            }catch(Exception e){
                e.printStackTrace();
            }
            try{
                fis.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
