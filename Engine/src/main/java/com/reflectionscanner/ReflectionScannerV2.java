package com.reflectionscanner;

import com.*;
import org.reflections.*;
import org.reflections.scanners.*;

import java.lang.reflect.*;
import java.util.*;

/**
 * @author Jakub Czajka
 */
public class ReflectionScannerV2 {

    private final Reflections reflections;
    private InvokeLevel invokeLevel = InvokeLevel.LOW;
    private boolean access = false;

    public ReflectionScannerV2(String packageName) {
        this.reflections = new Reflections(packageName, new MethodAnnotationsScanner());
    }

    public ReflectionScannerV2 setInvokeLevel(InvokeLevel invokeLevel) {
        this.invokeLevel = invokeLevel;
        return this;
    }

    public ReflectionScannerV2 setPrivateAccess(boolean privateAccess) {
        this.access = privateAccess;
        return this;
    }

    public void run() {
        Set<Method> annotatedMethods = new HashSet<>(reflections.getMethodsAnnotatedWith(Run.class));
        runTests();
        annotatedMethods.removeIf(
                method -> method.getAnnotation(Run.class).invokeLevel().getInvokeLevel() < invokeLevel
                        .getInvokeLevel());
        if (access) {
            annotatedMethods.stream().filter(method -> Modifier.isPrivate(method.getModifiers()))
                    .forEach(method -> method.setAccessible(true));
        } else {
            annotatedMethods.removeIf(method -> Modifier.isPrivate(method.getModifiers()));
        }
        for (Method method : annotatedMethods) {
            Class<?> declaringClass = method.getDeclaringClass();
            try {
                method.invoke(declaringClass.getDeclaredConstructor().newInstance());
            } catch (IllegalAccessException | InvocationTargetException | InstantiationException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }

    private void runTests() {
        System.out.println("run");
    }
}
