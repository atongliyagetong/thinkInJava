package chapter18_JavaIO.chapter18_6_IO_typicalExample;

import java.io.*;

/**
 * 18.6.4 基本的文件输出
 */
public class BasicFileOutput {
    static String filename = "BasicFileOutput.out";

    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read("BasicFileOutput.java")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
        /**
         * 文本文件输出的快捷方式
         */
        PrintWriter outShortCut = new PrintWriter(filename);
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null) {
//            out.println(lineCount++ + ":" + s );
            outShortCut.println(lineCount++ + ":" + s );
        }
        outShortCut.close();
        out.close();
        in.close();
        System.out.println(BufferedInputFile.read(filename));
    }
}