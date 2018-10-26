package chapter18_JavaIO.chapter18_10_NIO.chapter18_10_7;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * 对映射文件的部分加锁
 * 使用多线程对同一个文件
 */
public class LockingMappedFile {
    static final int LENGTH = 0X8FFFFFF;//143M
    static FileChannel fc;

    public static void main(String[] args) throws Exception{
        fc = new RandomAccessFile("test.txt", "rw").getChannel();
        MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_WRITE, 0, LENGTH);
        for (int i = 0; i < LENGTH; i++) {
            mbb.put((byte) 'x');
//            new LockAndModify(mbb, 0, 0 + LENGTH / 3);
//            new LockAndModify(mbb, LENGTH / 2, LENGTH / 2 + LENGTH / 4);
        }
    }
    private static class LockAndModify extends Thread{
        private ByteBuffer byteBuffer;
        private int start, end;

        LockAndModify(ByteBuffer mbb, int start, int end) {
            this.start = start;
            this.end = end;
            mbb.limit(end);
            mbb.position(start);
            mbb.slice();
            start();
        }
        public void run() {
            try {
                FileLock fileLock = fc.lock(start, end, false);
                System.out.println("locked:" + start + " to " + end);
                while (byteBuffer.position() < byteBuffer.limit() - 1) {
                    byteBuffer.put((byte) (byteBuffer.get() + 1));
                }
                fileLock.release();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
