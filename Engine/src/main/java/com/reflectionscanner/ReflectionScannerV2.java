package com.reflectionscanner;

import com.ExpectedException;
import com.InvokeLevel;
import com.Run;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

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
    Set<Method> annotatedMethods = new HashSet<>(getAnnotatedMethods());
    System.out.println("run");
    annotatedMethods = createMethodsToRun(annotatedMethods, invokeLevel, access);
    runEveryMethod(annotatedMethods);
  }

  void runEveryMethod(Set<Method> methodsToRun) {
    for (Method method : methodsToRun) {
      Class<?> declaringClass = method.getDeclaringClass();
      try {
        method.invoke(declaringClass.getDeclaredConstructor().newInstance());
      } catch (IllegalAccessException | InvocationTargetException | InstantiationException | NoSuchMethodException e) {
        e.printStackTrace();
      } catch (Exception e){
        System.out.println(e.getClass());
      }
    }
  }

  private Set<Method> createMethodsToRun(Set<Method> annotatedMethods, InvokeLevel invokeLevel, boolean privateAccess) {
    removeMethodWithTooLowInvokeLevel(annotatedMethods, invokeLevel);
    removeOrSetAccessToPrivateMethods(annotatedMethods, privateAccess);
    return annotatedMethods;
  }

  private void removeOrSetAccessToPrivateMethods(Set<Method> annotatedMethods, boolean privateAccess) {
    if (privateAccess)
      annotatedMethods.stream().filter(method -> Modifier.isPrivate(method.getModifiers())).forEach(method -> method.setAccessible(true));
    else
      annotatedMethods.removeIf(method -> Modifier.isPrivate(method.getModifiers()));
  }

  private void removeMethodWithTooLowInvokeLevel(Set<Method> annotatedMethods, InvokeLevel invokeLevel) {
    annotatedMethods.removeIf(method -> method.getAnnotation(Run.class).invokeLevel().getInvokeLevel() < invokeLevel.getInvokeLevel());
  }

  private Set<Method> getAnnotatedMethods() {
    return reflections.getMethodsAnnotatedWith(Run.class);
  }


}
