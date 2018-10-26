package chapter18_JavaIO.chapter18_10_NIO.chapter18_10_5;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * 18.10.5 缓冲器的细节
 * capacity() 返回缓冲区容量
 * clear（）  清空缓冲区，position设置为0，limit设置为容量
 * flip()     将limit设置成position，position设置为0。用此方法准备从缓冲区读取已经写入的数据
 * limit()    返回limit值
 * limit(int lim)   设置limit值
 * mark()       将mark设置为position
 * position()   返回position值
 * position(int pos) 设置position
 * remaining()  返回（limit-position）
 * hasRemaining() 若有介于limit和position的元素，返回true
 * reset() 将position的值设置为mark值
 * rewind() 将position设置为为0
 */
public class UsingBuffers {

    /**
     * 交换相邻字符，对CharBuffer中的字符进行编码和解码
     * @param charBuffer
     */
    public static void symmetricScramble(CharBuffer charBuffer) {
        while (charBuffer.hasRemaining()) {
            charBuffer.mark();
            char c1 = charBuffer.get();
            char c2 = charBuffer.get();
            charBuffer.reset();
            charBuffer.put(c2).put(c1);
        }
    }

    public static void main(String[] args) {
        char[] data = "UsingBuffers".toCharArray();
        ByteBuffer bb = ByteBuffer.allocate(data.length * 2);
        CharBuffer cb = bb.asCharBuffer();
        cb.put(data);
        System.out.println(cb.rewind());
        symmetricScramble(cb);
        System.out.println(cb.rewind());
        symmetricScramble(cb);
        System.out.println(cb.rewind());
    }
}
