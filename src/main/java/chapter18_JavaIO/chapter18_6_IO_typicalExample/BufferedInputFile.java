package chapter18_JavaIO.chapter18_6_IO_typicalExample;

import java.io.*;

/**
 * 18.6.1缓冲输入文件
 */
public class BufferedInputFile {
    public static String read(String filename) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filename),"UTF-8"));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = bufferedReader.readLine()) != null) {
            sb.append(s + "\n");
        }
        bufferedReader.close();
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(read("BufferedInputFile.java"));

    }
}
