package byte_IO;

import java.io.FileOutputStream;
import java.io.IOException;

public class Test2 {
    public static void main(String[] args) throws IOException{
        /*
         * void write(int b)                        一次写一个字节数据
         * void write(byte[] b)                     一次写一个字节数组数据
         * void write(byte[] b,int off,int len)     一次写一个字节数组的部分数据，off表示起始索引，len表示写入长度
         */

        FileOutputStream fos=new FileOutputStream("E:\\5e\\b.txt");
        
        //方法一
        fos.write(115); //s
        fos.write(98); //b

        //方法二
        byte[] bytes={119,115,110,100};
        fos.write(bytes); //wsnd

        //方法三
        fos.write(bytes,2,2); //nd

        fos.close();
    }
}
