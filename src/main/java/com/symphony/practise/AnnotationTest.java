package com.symphony.practise;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationTest {
    static void main() throws InvocationTargetException, IllegalAccessException {
        RepeatFunction repeatFunction = new RepeatFunction();
        Method[] functions = repeatFunction.getClass().getMethods();
        for (Method function : functions) {
            if (function.isAnnotationPresent(Repeat.class)) {
                Repeat repeat = function.getAnnotation(Repeat.class);
                int times = repeat.times();
                while (times > 0) {
                    function.invoke(repeatFunction);
                    times--;
                }
            }
        }
    }
}
