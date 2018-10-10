package chapter18_JavaIO.chapter18_1.chapter18_1_2;

import chapter18_JavaIO.util.PPrint;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 18.1.2 目录实用工具
 */
public final class Directory {
    public static File[] local(File dir, final String regex) {
        return dir.listFiles(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);
            public boolean accept(File dir, String name) {
                return pattern.matcher(new File(name).getName()).matches();
            }
        });
    }

    //overload
    public static File[] local(String path, final String regex) {
        return local(new File(path), regex);
    }

    /**
     * 设置一个元组
     */
    public static class TreeInfo implements Iterable<File> {
        public List<File> files = new ArrayList<>();
        public List<File> dirs = new ArrayList<>();

        @Override
        public Iterator<File> iterator() {
            return files.iterator();
        }

        void addAll(TreeInfo treeInfo) {
            files.addAll(treeInfo.files);
            dirs.addAll(treeInfo.dirs);
        }

        @Override
        public String toString() {
            return "dirs: " + PPrint.pformat(dirs) +
                    "\n\nfiles:" + PPrint.pformat(files);
        }
    }

    public static TreeInfo walk(String start, String regex) {
        //Begin recursion
        TreeInfo result = recurseDirs(new File(start), regex);
        return result;
    }

    public static TreeInfo walk(File start, String regex) {
        //Begin recursion
        TreeInfo result = recurseDirs(start, regex);
        return result;
    }
    public static TreeInfo walk(File start) {
        //Begin recursion
        return recurseDirs(start, ".*");
    }
    public static TreeInfo walk(String start) {
        //Begin recursion
        TreeInfo result = recurseDirs(new File(start), ".*");
        return result;
    }

    /**
     * 递归调用，返回元组TreeInfo
     * TreeInfo : files + dirs
     * files:所有普通文件（带路径）
     * dirs:所有目录
     * @param startDir
     * @param regex
     * @return
     */
    static TreeInfo recurseDirs(File startDir, String regex) {
        TreeInfo treeInfo = new TreeInfo();
        for (File item : startDir.listFiles()) {
            if (item.isDirectory()) {
                treeInfo.dirs.add(item);
                treeInfo.addAll(recurseDirs(item, regex));
            }
            if (item.isFile()) {
                if (item.getName().matches(regex)) {
                    treeInfo.files.add(item);
                }
            }
        }
        return treeInfo;
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println(walk("."));
        } else{
            for (String arg : args) {
                System.out.println(walk(arg));
            }
        }
    }


}



