package chapter18_JavaIO.chapter18_7_FileUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * 18.7文件读取工具
 */
public class TextFile extends ArrayList<String> {
    public static String read(String fileName) {
        StringBuilder sb = new StringBuilder();
        BufferedReader in = null;
        try {
            try {
                in = new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                in.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static void write(String filename, String text) {
        PrintWriter out = null;
        try {
            out = new PrintWriter(new File(filename).getAbsoluteFile());
            out.print(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            out.close();
        }
    }

    public TextFile(String fileName, String splitter) {
        super(Arrays.asList(read(fileName).split(splitter)));

        if (get(0).equals("")) {
            remove(0);
        }
    }

    public TextFile(String fileName) {
        this(fileName, "\n");
    }

    public void write(String fileName) {
        try {
            PrintWriter out = new PrintWriter(new FileWriter(new File(fileName).getAbsoluteFile()));
            try {
                for (String item : this) {
                    out.println(item);
                }
            } finally {
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String file = read("TextFile.java");
        write("test.txt", file);
        TextFile textFile = new TextFile("test.txt");
        textFile.write("test2.txt");

        TreeSet<String> words = new TreeSet<String>(new TextFile("TextFile.java", "\\W+"));
        System.out.println(words.headSet("a"));
    }
}
