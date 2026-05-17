package byte_IO;

import java.io.FileOutputStream;
import java.io.IOException;

public class Test1 {
    public static void main(String[] args) throws IOException{
        /*
         * 1.创建字节输出流对象
         *   a.参数为字符串表示的路径，或者为File对象
         *   b.如果文件不存在则会创建一个新的文件，但是必须保证父级路径存在
         *   c.如果文件已存在，则会清空文件后再执行
         *  2.写出数据
         *   write方法的参数是整数，实际写入本地文件中的参数为对应的ASCII码
         *  3.释放资源
         *   每次使用完后都要释放资源，防止资源占用
         */
        FileOutputStream fos=new FileOutputStream("E:\\5e\\a.txt");
        fos.write(114514);
        fos.close();
    }
}
