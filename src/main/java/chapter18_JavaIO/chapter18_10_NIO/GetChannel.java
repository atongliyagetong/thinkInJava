package chapter18_JavaIO.chapter18_10_NIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * NIO 提高速度
 * 文件IO和网络IO
 * 速度提升使用的结构：通道和缓冲器 （Channel And Buffer）
 * 唯一直接与通道交互的缓冲器 ByteBuffer
 * 旧IO类库中有三个类被修改了：FileInputStream、FileOutputStream、RandomAccessFile，用以产生
 * byteBuffer.allocate(int size)  分配大小
 * byteBuffer.flip() FileChannel调用了read()或ByteBuffer调用put()后，使用flip,为channel-write或ByteBuffer.get()做准备
 * byteBuffer.clear()
 * byteBuffer.get()
 */
public class GetChannel {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception{
        FileChannel fc = new FileOutputStream("data.txt").getChannel();
        fc.write(ByteBuffer.wrap("some thing ".getBytes()));
        fc.close();
        //add to the end of the file
        fc = new RandomAccessFile("data.txt", "rw").getChannel();
        fc.position(fc.size());
        fc.write(ByteBuffer.wrap("some more".getBytes()));
        fc.close();
        //read the file
        fc = new FileInputStream("data.txt").getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        fc.read(buffer);
        buffer.flip();
        while (buffer.hasRemaining()) {
            System.out.print((char)buffer.get());
        }
    }
}
