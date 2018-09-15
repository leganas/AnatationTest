package com.company;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestLibrary {

    public TestLibrary() {
        Class clazz= this.getClass();
        Annotation[] annotations_class =  clazz.getAnnotations();
        for (Annotation a : annotations_class) {
            System.out.println("@" + a.annotationType().getSimpleName() + " ");
            if (a instanceof Controller) {
                System.out.println("Экземпляр класса является контролером");
            }
        }
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            Annotation[] annotations = m.getAnnotations();
                for (Annotation a : annotations) {
                System.out.println("@" + a.annotationType().getSimpleName() + " ");
                if (a instanceof StartMetod) {
                    String msg = ((StartMetod) a).msg();
                    try {
                        m.invoke(this, msg);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}
