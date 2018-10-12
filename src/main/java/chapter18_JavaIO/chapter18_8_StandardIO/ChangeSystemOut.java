package chapter18_JavaIO.chapter18_8_StandardIO;

import java.io.PrintWriter;

/**
 * 18.8.2 将System.out转换成PrintWriter
 */
public class ChangeSystemOut {
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out, true);
        out.println("hasaki!!!");
    }
}
