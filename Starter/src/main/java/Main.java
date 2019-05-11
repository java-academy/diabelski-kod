import com.InvokeLevel;
import com.reflectionscanner.ReflectionScannerV2;
import main.ReflectionClassOne;

/**
 * @author Kacper Staszek
 */
class Main {

  public static void main(String[] args) {
   ReflectionScannerV2 reflectionScannerV2 = new ReflectionScannerV2(Main.class.getPackageName()).setInvokeLevel(InvokeLevel.LOW).setPrivateAccess(true);
   reflectionScannerV2.run();
  }
}
