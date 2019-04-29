package com.reflectionscanner;


import com.InvokeLevel;
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
    executeMethods(InvokeLevel.LOW);
  }

  public void runAllMethodsWithAnnotationByPriority(InvokeLevel runInvokeLevel) {
    executeMethods(runInvokeLevel);
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

  private void executeMethods(InvokeLevel invokeLevel) {
    for (Method method : annotatedMethods) {
      try {
        checkPriorityAndRun(invokeLevel, method);
      } catch (IllegalAccessException | InvocationTargetException | InstantiationException | NoSuchMethodException e) {
        e.printStackTrace();
      }
    }
  }
  private void collectAnnotatedMethods() {
    annotatedMethods = reflections.getMethodsAnnotatedWith(Run.class);
  }

  private void checkPriorityAndRun(InvokeLevel invokeLevel, Method method)
      throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
    Class<?> declaringClass = method.getDeclaringClass();
    Run annotation = method.getAnnotation(Run.class);
    if(methodIsNotPrivate(method.getModifiers())){
      if (annotation.invokeLevel().getInvokeLevel() >= invokeLevel.getInvokeLevel()) {
        method.invoke(declaringClass.getDeclaredConstructor().newInstance());
      }
    }
  }

  private boolean methodIsNotPrivate(int modifiers) {
    return modifiers!=2;
  }


}


