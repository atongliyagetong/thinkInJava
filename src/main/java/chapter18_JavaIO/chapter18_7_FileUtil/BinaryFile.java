package chapter18_JavaIO.chapter18_7_FileUtil;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 18.7.1 读取二进制文件
 */
public class BinaryFile {
    public static byte[] read(File bFile) throws IOException {
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(bFile));
        byte[] data;
        try {
            data = new byte[in.available()];
            in.read(data);
        } finally {
            in.close();
        }
        return data;
    }
    public static byte[] read(String bFile) throws IOException{
        return read(new File(bFile).getAbsoluteFile());
    }

    public static void main(String[] args) throws IOException{
        byte[] bytes = read("BinaryFile.java");
        String str = new String(bytes);
        System.out.println(str);
        System.exit(0);
    }
}
