package byte_IO;

import java.io.FileInputStream;
import java.io.IOException;

public class Test5 {
    public static void main(String[] args) throws IOException{
        //字节输入流循环读取
        FileInputStream fis=new FileInputStream("E:\\5e\\b.txt");

        //循环读取
        int b;
        while((b=fis.read())!=-1){
            System.out.print((char)b); //sbwsndnd
        }
        fis.close();
    }
}
