package chapter18_JavaIO.chapter18_10_NIO;

import java.nio.ByteBuffer;

/**
 * 18.10.2 获取基本类型
 */
public class GetData {
    public static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception{
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        int i = 0;
        while (i++ < buffer.limit()) {
            if (buffer.get() != 0) {
                System.out.println("nonzero");
            }
        }
        System.out.println(i);
        //buffer写String
        buffer.rewind();
        buffer.asCharBuffer().put("HASAKI!!!");
        char c;
        while ((c = buffer.getChar()) != 0) {
            System.out.print(c);
        }
        System.out.println();
        //buffer写int
        buffer.rewind();
        buffer.asIntBuffer().put(12);
        System.out.println(buffer.getInt());
        //buffer写double
        buffer.rewind();
        buffer.asDoubleBuffer().put(12.345);
        System.out.println(buffer.getDouble());
        //buffer写float
        buffer.rewind();
        buffer.asFloatBuffer().put(323432134);
        System.out.println(buffer.getFloat());
    }
}
