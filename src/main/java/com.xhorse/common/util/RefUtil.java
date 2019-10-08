package com.xhorse.common.util;
import javax.inject.Singleton;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Singleton
public class RefUtil {


    public static <T> T execute(Class<?> clazz, Object obj, String methodName) {
        try {
            Method method = clazz.getMethod(methodName);
            return method == null ? null : (T) method.invoke(obj);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> T executePrivate(Class<?> clazz, Object obj, String methodName) {
        try {
            Method methodPrivate = clazz.getDeclaredMethod(methodName);
            methodPrivate.isAccessible();
            methodPrivate.setAccessible(true);//调private方法
            return (T) methodPrivate.invoke(obj);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }

    }


    public static <T> T execute(Class<?> objclass, Object obj, String methodName, T value) {
        try {
            if (value == null) return null;
            Method func = objclass.getMethod(methodName, value.getClass());
            if (func != null) {
                return (T) func.invoke(obj, value);
            } else {
                return null;
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> T executeInt(Class<?> objclass, Object obj, String methodName, int value) {
        try {
            Method func = objclass.getMethod(methodName, int.class);
            return (T) func.invoke(obj, value);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> T executeDouble(Class<?> objclass, Object obj, String methodName, double value) {
        try {
            Method func = objclass.getMethod(methodName, double.class);
            return (T) func.invoke(obj, value);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> T executeFloat(Class<?> objclass, Object obj, String methodName, float value) {
        try {
            Method func = objclass.getMethod(methodName, float.class);
            return (T) func.invoke(obj, value);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static <T> T executeLong(Class<?> objclass, Object obj, String methodName, long value) {
        try {
            Method func = objclass.getMethod(methodName, long.class);
            return (T) func.invoke(obj, value);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }


}
