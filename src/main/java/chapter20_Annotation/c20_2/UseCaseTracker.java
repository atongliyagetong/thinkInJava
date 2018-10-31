package chapter20_Annotation.c20_2;

import chapter20_Annotation.c20_1.UseCase;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 使用反射访问方法里的注解信息
 * 显示注解信息，以及不是注解id的信息
 * 注解类不能在同一个包下，不然method.getAnnotation()会显示访问不到，原因不知道aaaa
 */
public class UseCaseTracker {


    public static void trackUserCases(List<Integer> useCases, Class<?> cl) {
        for (Method m : cl.getDeclaredMethods()) {
            UseCase uc = m.getAnnotation(UseCase.class);
            System.out.println("found Use Case:" + uc.id() + " " + uc.description());
            useCases.remove(new Integer(uc.id()));
        }
        for (Integer integer : useCases) {
            System.out.println("Warning : missing use case-" + integer);
        }
    }

    public static void main(String[] args) {
        List<Integer> useCases = new ArrayList<>();
        Collections.addAll(useCases, 47, 48, 49, 50);
        trackUserCases(useCases, PasswordUtil.class);
    }

}

