import com.reflectionscanner.ReflectionScanner;

/**
 * @author Kacper Staszek
 */
class Try {

  public static void main(String[] args) {


    ReflectionScanner reflectionScanner = new ReflectionScanner(packageName, reflections);
    reflectionScanner.runAllMethodsWithAnnotation(Try.class.getPackageName(),2);

  }
}
