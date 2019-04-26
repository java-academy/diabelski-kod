import com.reflectionscanner.ReflectionScanner;

/**
 * @author Kacper Staszek
 */
class Main {

  public static void main(String[] args) {

    ReflectionScanner reflectionScanner = new ReflectionScanner(args[0]);

    reflectionScanner.runAllMethodsIncludePrivate();

    reflectionScanner.runAllMethodsWithAnnotation();

    reflectionScanner.runAllMethodsWithAnnotationByPriority(3);

  }
}
