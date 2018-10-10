package chapter18_JavaIO.util;

import java.util.Arrays;
import java.util.Collection;

public class PPrint {
    public static String pformat(Collection<?> c) {
        if (c.size() == 0) {
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder("[");
        for (Object object : c) {
            if (c.size() != 1) {
                stringBuilder.append("\n ");
                stringBuilder.append(object);
            }
        }
        if (c.size() != 1) {
            stringBuilder.append("\n ");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static void pprint(Collection<?> c) {
        System.out.println(pformat(c));
    }

    public static void pprint(Object[] objects) {
        System.out.println(pformat(Arrays.asList(objects)));
    }
}
