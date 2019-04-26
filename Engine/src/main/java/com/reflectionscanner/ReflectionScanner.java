package com.reflectionscanner;


import com.Run;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;

/**
 * Scan package and looks after all methods annotated methods, than run them based
 * on requirements.
 *
 * @author Kacper Staszek
 */
public class ReflectionScanner {

  private Set<Method> annotatedMethods;

  private final String packageName;

  private final Reflections reflections;

  public ReflectionScanner(String packageName, Reflections reflections) {
    this.packageName = packageName;
    this.reflections = new Reflections(packageName, new MethodAnnotationsScanner());
    collectAnnotatedMethods(this.reflections);
  }

  public void runAllMethodsWithAnnotation(){

  }

  public void runAllMethodsWithAnnotation(int runPriority) {

    executeMethods(runPriority);

  }

  private void executeMethods(int runPriority) {
    for (Method method : annotatedMethods) {
      Class<?> declaringClass = method.getDeclaringClass();
      try {
        checkPriorityAndRun(runPriority, method, declaringClass);
      } catch (IllegalAccessException | InvocationTargetException | InstantiationException | NoSuchMethodException e) {
        e.printStackTrace();
      }
    }
  }

  private void collectAnnotatedMethods(Reflections reflections) {
    annotatedMethods = reflections.getMethodsAnnotatedWith(Run.class);
  }

  private void checkPriorityAndRun(int runPriority, Method method, Class<?> declaringClass)
      throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
    Run annotation = method.getAnnotation(Run.class);
    int priority = annotation.priority();
    if (priority >= runPriority) {
      method.invoke(declaringClass.getDeclaredConstructor().newInstance());
    }
  }

}


