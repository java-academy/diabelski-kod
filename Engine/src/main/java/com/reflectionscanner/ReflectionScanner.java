package com.reflectionscanner;


import com.Priority;
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

  private final Reflections reflections;

  public ReflectionScanner(String packageName) {
    this.reflections = new Reflections(packageName, new MethodAnnotationsScanner());
    collectAnnotatedMethods();
  }

  public void runAllMethodsWithAnnotation(){
    executeMethods(Priority.LOW);
  }

  public void runAllMethodsWithAnnotationByPriority(Priority runPriority) {
    executeMethods(runPriority);
  }

  public void runAllMethodsIncludePrivate(){
    for (Method method : annotatedMethods) {
      Class<?> declaringClass = method.getDeclaringClass();
      method.setAccessible(true);
      try {
        method.invoke(declaringClass.getConstructor().newInstance());
      } catch (IllegalAccessException | InvocationTargetException | InstantiationException | NoSuchMethodException e) {
        e.printStackTrace();
      }
    }
  }

  private void executeMethods(Priority priority) {
    for (Method method : annotatedMethods) {
      try {
        checkPriorityAndRun(priority, method);
      } catch (IllegalAccessException | InvocationTargetException | InstantiationException | NoSuchMethodException e) {
        e.printStackTrace();
      }
    }
  }

  private void collectAnnotatedMethods() {
    annotatedMethods = reflections.getMethodsAnnotatedWith(Run.class);
  }

  private void checkPriorityAndRun(Priority priority, Method method)
      throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
    Class<?> declaringClass = method.getDeclaringClass();
    Run annotation = method.getAnnotation(Run.class);
    if(methodIsNotPrivate(method.getModifiers())){
      if (annotation.priority().getPriority() >= priority.getPriority()) {
        method.invoke(declaringClass.getDeclaredConstructor().newInstance());
      }
    }
  }

  private boolean methodIsNotPrivate(int modifiers) {
    return modifiers!=2;
  }

}


