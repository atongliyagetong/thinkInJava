package chapter18_JavaIO.chapter18_10_NIO.chapter18_10_6;

import java.io.*;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

/**
 * 18.10.6 内如映射文件性能测试
 */
public class MappedIO {
    private static int numOfInts = 4000000;
    private static int numOfUbuffInts = 200000;
    private abstract static class Tester{
        private String name;
        public Tester(String name){this.name=name;}

        public void runTest() {
            System.out.print(name + ": ");
            try {
                long start = System.nanoTime();
                test();
                double duration = System.nanoTime() - start;
                System.out.format("%.2f\n", duration / 1.0e9);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public abstract void test() throws IOException;
    }

    private static Tester[] tests = {
        new Tester("Stream write") {
            @Override
            public void test() throws IOException {
                DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("temp.tmp")));
                for (int i = 0; i < numOfInts; i++) {
                    out.writeInt(i);
                }
                out.close();
            }
        },
        new Tester("Mapped write") {
            @Override
            public void test() throws IOException {
                FileChannel fc = new RandomAccessFile("temp.tmp", "rw").getChannel();
                IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size()).asIntBuffer();
                for (int i = 0; i < numOfInts; i++) {
                    ib.put(i);
                }
                fc.close();
            }
        },
        new Tester("Stream read") {
            @Override
            public void test() throws IOException {
                DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("temp.tmp")));
                for (int i = 0; i < numOfInts; i++) {
                    in.readInt();
                }
                in.close();
            }
        },
        new Tester("Mapped read") {
            @Override
            public void test() throws IOException {
                FileChannel fc = new RandomAccessFile("temp.tmp", "r").getChannel();
                IntBuffer ib = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size()).asIntBuffer();
                while (ib.hasRemaining()) {
                    ib.get();
                }
                fc.close();
            }
        },
        new Tester("Stream read/write") {
            @Override
            public void test() throws IOException {
                RandomAccessFile raf = new RandomAccessFile("temp.tmp", "rw");
                raf.writeInt(1);
                for (int i = 0; i < numOfUbuffInts; i++) {
                    raf.seek(raf.length() - 4);
                    raf.writeInt(raf.readInt());
                }
                raf.close();
            }
        },
        new Tester("Mapped read/write") {
            @Override
            public void test() throws IOException {
                FileChannel fc = new RandomAccessFile("temp.tmp", "rw").getChannel();
                IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size()).asIntBuffer();
                ib.put(0);
                for (int i = 1; i < numOfUbuffInts; i++) {
                    ib.put(ib.get(i - 1));
                }
                fc.close();
            }
        }
    };

    public static void main(String[] args) {
        for (Tester test : tests) {
            test.runTest();
        }
    }
}
