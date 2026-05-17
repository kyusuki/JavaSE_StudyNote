package character_IO;

import java.io.FileOutputStream;
import java.io.IOException;

public class Test3 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos=new FileOutputStream("F:\\code\\java\\SuperAdvanced\\IO\\character_IO\\b.txt");
        fos.write(97);
        fos.close();
    }
}
