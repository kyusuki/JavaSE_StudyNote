package byte_IO;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Test7 {
    public static void main(String[] args) throws IOException{
        FileInputStream fis=new FileInputStream("E:\\5e\\b.txt");
        byte[] bt=new byte[2];
        int len=fis.read(bt);
        System.out.println(len); //2
        System.out.println(new String(bt)); //sb
        System.out.println(Arrays.toString(bt)); //[115, 98]
        fis.close();
    }
}
