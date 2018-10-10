package chapter18_JavaIO.chapter18_6_IO_typicalExample;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class TestEOF {
    public static void main(String[] args){
        try {
            DataInputStream in = new DataInputStream(new ByteArrayInputStream(BufferedInputFile.read("TestEOF.java").getBytes()));
            while (in.available() != 0) {
                System.out.print((char) in.readByte());
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("END OF THE STREAM");
        }
    }

}
