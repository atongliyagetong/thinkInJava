package chapter18_JavaIO.chapter18_10_NIO.chapter18_10_6;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 18.10.6 内存映射文件
 */
public class LargeMappedFiles {
    static int length = 0X8FFFFFF;//128M

    public static void main(String[] args) throws Exception{
        MappedByteBuffer out = new RandomAccessFile("text.dat", "rw").getChannel()
                .map(FileChannel.MapMode.READ_WRITE, 0, length);
        for (int i = 0; i < length; i++) {
            out.put((byte) 'x');
        }
        System.out.println("Finish writing");
        for (int i = length / 2; i < length / 2 + 6; i++) {
            System.out.print((char)out.get(i));
        }
    }
}
