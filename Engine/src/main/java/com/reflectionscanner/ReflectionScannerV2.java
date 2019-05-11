package com.reflectionscanner;

import com.InvokeLevel;
import com.Run;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Jakub Czajka
 */
public class ReflectionScannerV2 {

    private final Reflections reflections;
    private InvokeLevel invokeLevel;
    private boolean access;
    public ReflectionScannerV2(String packageName, InvokeLevel invokeLevel, boolean access) {
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        configurationBuilder.addUrls(ClasspathHelper.forClass(Object.class));
        configurationBuilder.forPackages(packageName);
        configurationBuilder.addScanners(new MethodAnnotationsScanner());
        this.reflections = new Reflections(configurationBuilder);
        this.access = access;
        this.invokeLevel = invokeLevel;
    }

    public void run() {
        HashSet<Method> annotatedMethods = new HashSet<>(reflections.getMethodsAnnotatedWith(Run.class));
        runTests();
        annotatedMethods.removeIf(
                method -> method
                        .getAnnotation(Run.class)
                        .invokeLevel()
                        .getInvokeLevel() < invokeLevel
                        .getInvokeLevel());
        if (access) {
            annotatedMethods.stream()
                    .filter(method -> Modifier
                            .isPrivate(method
                            .getModifiers()))
                    .forEach(method -> method
                            .setAccessible(true));
        } else {
            annotatedMethods
                    .removeIf(method -> Modifier
                            .isPrivate(method.getModifiers()));
        }
        for (Method method : annotatedMethods) {
            Class<? extends Object> declaringClass = method.getDeclaringClass();
            try {
                method.invoke(declaringClass
                        .getDeclaredConstructor()
                        .newInstance());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException f) {
                f.printStackTrace();
            } catch (InstantiationException g) {
                g.printStackTrace();
            } catch (InvocationTargetException h) {
                h.printStackTrace();
            }
        }
    }

    private void runTests() {
        System.out.println("run");
    }
}
