package chapter18_JavaIO.chapter18_6_IO_typicalExample;

import java.io.IOException;
import java.io.StringReader;

/**
 * 18.6.2从内存输入
 */
public class MemoryInput {

    public static void main(String[] args) throws IOException {
        StringReader in = new StringReader(BufferedInputFile.read("MemoryInput.java"));
        int c;
        while ((c = in.read()) != -1) {
            System.out.print((char)c);
        }
    }
}
