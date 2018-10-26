package chapter18_JavaIO.chapter18_10_NIO.chapter18_10_7;

import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

/**
 * 18.10.7 文件加锁
 * 对FileChannel调用tryLock() 或 lock()
 * tryLock() 非阻塞式 设法获得锁，无法获得时直接返回
 * lock() 阻塞式 阻塞进程直到锁可以获得，或调用lock()的方法线程中断，或调用lock()的通道关闭
 * release() 释放锁
 * tryLock(long position, long size, boolean shared) 锁住文件部分
 * lock(long position, long size, boolean shared) 锁住文件部分
 * 独享锁/共享锁 由isShared()来判断
 */
public class FileLocking {

    public static void main(String[] args) throws Exception {
        FileOutputStream out = new FileOutputStream("data.txt");
        FileLock fileLock = out.getChannel().tryLock();
        if (fileLock != null) {
            System.out.println("File locking");
            TimeUnit.MILLISECONDS.sleep(100);
            fileLock.release();
            System.out.println("release lock");
        }
        out.close();
    }
}
