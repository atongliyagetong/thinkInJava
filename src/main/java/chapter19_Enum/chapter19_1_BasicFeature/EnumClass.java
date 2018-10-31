package chapter19_Enum.chapter19_1_BasicFeature;


enum Shrubbery{GROUND, CRAWLING, HANGING}

/**
 * 19.1 enum 枚举的基本特性
 * values()返回枚举示例的数组
 * ordinal()返回枚举常数的序数 return the ordinal of this enumeration constant
 * compareTo() 根据次序数大于等于小于 返回正数 0 负数
 * == 比较enum实例，编译期自动提供equals()和hashCode()
 * getDeclaringClass() 返回所属的enum类
 * name()返回enum实例的名字
 */
public class EnumClass {
    public static void main(String[] args) {
        for (Shrubbery s : Shrubbery.values()) {
            System.out.println(s + " ordinal: " + s.ordinal());
            System.out.println(s.compareTo(Shrubbery.CRAWLING) + " ");
            System.out.println(s.equals(Shrubbery.CRAWLING) + " ");
            System.out.println(s==Shrubbery.CRAWLING);
            System.out.println(s.getDeclaringClass());
            System.out.println(s.name());
            System.out.println("-------------------");
        }
        //Produce an enum value from a String name;
        for (String s : "HANGING CRAWLING GROUND".split(" ")) {
            Shrubbery shrubbery = Enum.valueOf(Shrubbery.class, s);
            System.out.println(shrubbery);
        }
    }
}
