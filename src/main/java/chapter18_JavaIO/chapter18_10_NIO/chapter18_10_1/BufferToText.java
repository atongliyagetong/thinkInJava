package chapter18_JavaIO.chapter18_10_NIO.chapter18_10_1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * 18.10.1 转换数据 byte转char  ByteBuffer转CharBuffer
 * 用charBuffer 读文件
 * CharSet.forName(encoding).decode(buffer)
 */
public class BufferToText {
    public static final int BSIZE = 1024;

    public static void main(String[] args) throws IOException {
        FileChannel fc = new FileOutputStream("data2.txt").getChannel();
        fc.write(ByteBuffer.wrap("some thing".getBytes()));
        fc.close();
        fc = new FileInputStream("data2.txt").getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        fc.read(buffer);
        buffer.flip();
        //不生效，乱码
        System.out.println(buffer.asCharBuffer());
        buffer.rewind();
        //使用系统编码
        String encoding = System.getProperty("file.encoding");
        System.out.println("Decoded using " + encoding + ":" +
                Charset.forName(encoding).decode(buffer));
        fc = new FileOutputStream("data2.txt").getChannel();
        fc.write(ByteBuffer.wrap("utf-8 text".getBytes("UTF-8")));
        fc.close();
        fc = new FileInputStream("data2.txt").getChannel();
        buffer.clear();
        fc.read(buffer);
        buffer.flip();
        System.out.println(buffer.asCharBuffer());
        //用charBuffer 写
        fc = new FileOutputStream("data2.txt").getChannel();
        buffer = ByteBuffer.allocate(48);
        buffer.asCharBuffer().put("write charbuffer");
        fc.write(buffer);
        fc.close();
    }
}
