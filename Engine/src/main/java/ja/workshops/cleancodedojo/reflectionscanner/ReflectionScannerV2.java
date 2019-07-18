package ja.workshops.cleancodedojo.reflectionscanner;

import ja.workshops.cleancodedojo.InvokeLevel;
import ja.workshops.cleancodedojo.Run;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashSet;

/**
 * @author Jakub Czajka
 */
public class ReflectionScannerV2 {

    private final Reflections reflections;
    private InvokeLevel invokeLevel;
    private boolean access;
    public ReflectionScannerV2(String packageName, InvokeLevel invokeLevel, boolean access) {
        this.reflections = new Reflections(packageName, new MethodAnnotationsScanner());
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
