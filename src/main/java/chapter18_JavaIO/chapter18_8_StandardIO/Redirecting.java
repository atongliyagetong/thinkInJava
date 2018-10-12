package chapter18_JavaIO.chapter18_8_StandardIO;

import java.io.*;

/**
 * 18.8.3 标准I/O重定向
 * 将标准输入附接到文件上，并将标准输出和标准错误重定向到另一个文件
 */
public class Redirecting {
    public static void main(String[] args) throws IOException {
        PrintStream console = System.out;
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(new File("Redirecting.java")));
        PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream("test.txt")));
        System.setIn(in);//将标准输入附接到文件Redirecting.java上
        System.setOut(out);//将标准输出
        System.setErr(out);
        InputStream inputStream = System.in;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = br.readLine()) != null) {
            System.out.println(s);
            sb.append(s + "\n");
        }
        out.close();
        System.setOut(console);
        System.out.println(sb);
    }
}
