package character_IO;

import java.io.FileWriter;
import java.io.IOException;

public class Test4 {
    public static void main(String[] args) throws IOException {
        FileWriter fr=new FileWriter("F:\\code\\java\\SuperAdvanced\\IO\\character_IO\\b.txt");
        fr.write("你好宁梦");
        fr.close();
    }
}
