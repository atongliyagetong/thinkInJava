package chapter18_JavaIO.chapter18_10_NIO.chapter18_10_3;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * 18.10.3 视图缓冲器
 */
public class IntBufferDemo {
    public static final int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        IntBuffer ib = bb.asIntBuffer();
        ib.put(new int[]{11, 22, 33, 44, 55, 66, 77});
        System.out.println(ib.get(3));
        ib.put(3, 666);
        ib.flip();
        while (ib.hasRemaining()) {
            System.out.print(ib.get() + " ");
        }
    }
}
