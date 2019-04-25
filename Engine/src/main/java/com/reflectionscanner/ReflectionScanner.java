package com.reflectionscanner;


import com.Run;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;

/**
 * @author Kacper Staszek
 */
public class ReflectionScanner {

  public void runEverythingWithRun(String packageName){

    Reflections reflections = new Reflections(packageName, new MethodAnnotationsScanner());
    Set<Method> methods = reflections.getMethodsAnnotatedWith(Run.class);
    methods.forEach(method -> System.out.println(method.getName()));

    for (Method method : methods) {

      Class<?> declaringClass = method.getDeclaringClass();
      try {
        method.invoke(declaringClass.newInstance());
      } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
        e.printStackTrace();
      }

    }

  }

}
