package character_IO;

import java.io.FileReader;
import java.io.IOException;

public class Test1 {
    public static void main(String[] args) throws IOException {
        FileReader fr=new FileReader("F:\\code\\java\\SuperAdvanced\\IO\\character_IO\\a.txt");
        int num;

        /*
        * 读取数据read()
        * 字符流的底层也是字节流，默认也是一个字节一个字节的读取
        * 若遇到中文就会一次读取多个，GBK一次都两个字节，UTF-8一次读取三个字节
        *
        * read()方法细节：
        * 在读取之后，方法的底层还会进行解码并转成十进制，
        * 最终将这个十进制作为返回值，
        * 这个十进制的数据表示字符集上的数字
        *
        * 解码中文时，要想在结果获得中文，只需将十进制强转
        * */
        while((num=fr.read())!=-1){
            System.out.print((char)num);
        }
        fr.close();
    }
}
