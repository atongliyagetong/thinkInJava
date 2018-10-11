package chapter18_JavaIO.chapter18_6_IO_typicalExample;

import java.io.*;

public class StoringAndRecoveringData {
    public static void main(String[] args) throws Exception{
        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("Data.text")));
        out.writeDouble(3.12313);
        out.writeUTF("hasaki");
        out.writeInt(2);
        out.writeUTF("atongliyagetong");
        out.close();

        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("Data.text")));
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
        System.out.println(in.readInt());
        System.out.println(in.readUTF());
        in.close();

    }
}
