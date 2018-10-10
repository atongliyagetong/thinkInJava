package chapter18_JavaIO.chapter18_6_IO_typicalExample;

import java.io.*;

/**
 * 18.6.3 从格式化的内存输入
 */
public class FormattedMemoryInput {
    public static void main(String[] args){
       /* try {
            DataInputStream in = new DataInputStream(new ByteArrayInputStream(BufferedInputFile.read("FormattedMemoryInput.java").getBytes()));
            while (true) {
                System.out.print((char) in.readByte());
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("END OF THE STREAM");
        }*/

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("FormattedMemoryInput.java"), "UTF-8"));
            String s;
            StringBuilder stringBuilder = new StringBuilder();
            while ((s = in.readLine()) != null) {
                stringBuilder.append(s + "\n");
            }
            System.out.println(stringBuilder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
