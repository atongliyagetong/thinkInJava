package chapter18_JavaIO.chapter18_1_File.chapter18_1_3;

import java.io.File;

/**
 * 18.1.3 目录的检查和创建
 * File类不仅代表文件和目录，还可以
 *      创建新的目录和不存在的整个目录路径
 *      查看文件的特性（大小，最后修改日期，读写）
 *      检查File对象是目录还是文件
 *      删除文件
 */
public class MakeDirectories {
    public static void usage(){
        System.err.println(
                "Usage:MakeDirectories path1...\n" +
                        "Creates each path\n" +
                        "Usage:MakeDirectories -d path1 ...\n" +
                        "Deletes each path\n" +
                        "Usage:MakeDirectories -r path1 path2 \n" +
                        "Renames from path1 to path2");
        System.exit(1);
    }

    private static void fileData(File f) {
        System.out.println(
                "Absolute path: " + f.getAbsolutePath() +
                        "\n Can read: " + f.canRead() +
                        "\n Can write: " + f.canWrite() +
                        "\n getName: " + f.getName() +
                        "\n getParent: " + f.getParent() +
                        "\n getPath: " + f.getPath() +
                        "\n length: " + f.length() +
                        "\n lastModify: " + f.lastModified()
        );
        if (f.isFile()) {
            System.out.println("It's a file");
        }
        if (f.isDirectory()) {
            System.out.println("It's a Directory");
        }
    }

    public static void main(String[] args) {
        if (args.length < 1) usage();
        if (args[0].equals("-r")) {
            if(args.length != 3) usage();
            File old = new File(args[1]),
                    rname = new File(args[2]);
            old.renameTo(rname);
            fileData(old);
            fileData(rname);
            return;
        }
        int count = 0;
        boolean del = false;
        if (args[0].equals("-d")) {
            count++;
            del = true;
        }
        count--;
        while (++count < args.length) {
            File file = new File(args[count]);
            if (file.exists()) {
                System.out.println(file + "exists");
                if (del) {
                    System.out.println("deleting..." + file);
                    file.delete();
                }
            } else {
                if (!del) {
                    file.mkdirs();
                    System.out.println("create " + file);
                }
            }
            fileData(file);
        }
    }
}
