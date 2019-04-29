import com.Priority;
import com.reflectionscanner.ReflectionScanner;

/**
 * @author Kacper Staszek
 */
class Main {

  public static void main(String[] args) {

    ReflectionScanner reflectionScanner = new ReflectionScanner(Main.class.getPackageName());

    reflectionScanner.runAllMethodsIncludePrivate();

    reflectionScanner.runAllMethodsWithAnnotation();

    reflectionScanner.runAllMethodsWithAnnotationByPriority(Priority.MEDIUM);

  }
}
