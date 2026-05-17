package character_IO;

import java.io.FileWriter;
import java.io.IOException;

public class Test5 {
    public static void main(String[] args) throws IOException {
        FileWriter fr=new FileWriter("F:\\code\\java\\SuperAdvanced\\IO\\character_IO\\c.txt",true);
        char[] chars={'，','拯','救','宁','梦'};
        fr.write(chars);
        fr.close();
    }
}
