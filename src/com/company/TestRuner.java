package com.company;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestRuner {
    public void Analiz(Class<?> clazz){
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                    System.out.println("Найден метод для тестирования для запуска следует использовать экземпляр класса");
//                    method.invoke(null);
            }
        }
    }


    public void run(Object object){
        Class clazz = object.getClass();
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                try {
                    method.invoke(object);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    public void create_and_run(Class<?> clazz){
        try {
            Object obj = clazz.newInstance();
            run(obj);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }



}
