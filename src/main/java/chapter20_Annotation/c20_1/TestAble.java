package chapter20_Annotation.c20_1;

public class TestAble {
    public void excute() {
        System.out.println("Excuting .....");
    }

    @Test
    void testExcute() {
        excute();
    }

    public static void main(String[] args) {
        TestAble test = new TestAble();
        test.testExcute();
    }
}
