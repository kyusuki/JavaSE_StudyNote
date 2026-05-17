package character_IO;

import java.io.FileReader;
import java.io.IOException;

public class Test2 {
    public static void main(String[] args) throws IOException {
        FileReader fr=new FileReader("F:\\code\\java\\SuperAdvanced\\IO\\character_IO\\a.txt");
        char[] chars=new char[2];
        int len;

        /*
        * read(chars):读取数据，解码，强转三步合并，将强转之后的字符放到数组当中
        * 等同于空参的read+强制类型转换
        *
        * */
        while((len=fr.read(chars))!=-1){
            System.out.println(new String(chars,0,len));
        }
        fr.close();
    }
}
