package chapter18_JavaIO.chapter18_6_IO_typicalExample;

import java.io.RandomAccessFile;

/**'
 * 18.6.6 读写随机访
 */
public class UsingRandomAccessFile {
    static String fileName = "rtest.text";

    static void display() throws Exception{
        RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "r");
        for (int i = 0; i < 7; i++) {
            System.out.println("value" + i + ":" + randomAccessFile.readDouble());
        }
        System.out.println(randomAccessFile.readUTF());
    }

    public static void main(String[] args) throws Exception{
        RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw");
        for (int i = 0; i < 7; i++) {
            randomAccessFile.writeDouble(i * 1.413);
        }
        randomAccessFile.writeUTF("THE END");
        randomAccessFile.close();
        display();
        randomAccessFile = new RandomAccessFile(fileName, "rw");
        System.out.println("*****************");
        randomAccessFile.seek(0 * 8);
        randomAccessFile.writeDouble(3.121231);
        display();

    }
}
