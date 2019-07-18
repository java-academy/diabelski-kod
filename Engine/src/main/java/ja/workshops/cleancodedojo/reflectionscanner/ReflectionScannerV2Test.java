package ja.workshops.cleancodedojo.reflectionscanner;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;

import ja.workshops.cleancodedojo.InvokeLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author Jakub Czajka
 */
public class ReflectionScannerV2Test {

  ReflectionScannerV2 reflectionScanner;

  @BeforeMethod
  public void beforeEachMethod() {
    ReflectionScannerV2TestObject.testy = new int[6];
  }

  @Test
  public void whenInvokeLevelIsLowAndNoPrivateAccessIsSetThenOnlyOneMethodRun() {
    reflectionScanner = new ReflectionScannerV2(ReflectionScannerV2TestObject.class.getPackageName(),InvokeLevel.LOW,false);
    reflectionScanner.run();
    int[] methodsRuned = ReflectionScannerV2TestObject.testy;
    int[] methodThatShouldRunned = {1,1,1,0,0,0};
    assertArrayEquals(methodsRuned, methodThatShouldRunned);
  }

  @Test
  public void whenInvokeLevelIsMediumAndNoPrivateAccessIsSetThenOnlyOneMethodRun() {
    reflectionScanner = new ReflectionScannerV2(ReflectionScannerV2TestObject.class.getPackageName(),InvokeLevel.MEDIUM,false);
    reflectionScanner.run();
    int[] methodsRuned = ReflectionScannerV2TestObject.testy;
    int[] methodThatShouldRunned = {0,1,1,0,0,0};
    assertArrayEquals(methodsRuned, methodThatShouldRunned);
  }
  @Test
  public void whenInvokeLevelIsHightAndNoPrivateAccessIsSetThenOnlyOneMethodRun() {
    reflectionScanner = new ReflectionScannerV2(ReflectionScannerV2TestObject.class.getPackageName(),InvokeLevel.HIGH,false);
    reflectionScanner.run();
    int[] methodsRuned = ReflectionScannerV2TestObject.testy;
    int[] methodThatShouldRunned = {0,0,1,0,0,0};
    assertArrayEquals(methodsRuned, methodThatShouldRunned);
  }

  @Test
  public void whenInvokeLevelIsLowAndNoPrivateAccessIsSetOnTrueThenAllMethodRun() {
    reflectionScanner = new ReflectionScannerV2(ReflectionScannerV2TestObject.class.getPackageName(),InvokeLevel.LOW,true);
    reflectionScanner.run();
    int[] methodsRuned = ReflectionScannerV2TestObject.testy;
    int[] methodThatShouldRunned = {1,1,1,1,1,1};
    assertArrayEquals(methodsRuned, methodThatShouldRunned);
  }

  @Test
  public void whenInvokeLevelIsMediumAndNoPrivateAccessIsSetOnTrueThenAllMethodRun() {
    reflectionScanner = new ReflectionScannerV2(ReflectionScannerV2TestObject.class.getPackageName(),InvokeLevel.MEDIUM,true);
    reflectionScanner.run();
    int[] methodsRuned = ReflectionScannerV2TestObject.testy;
    int[] methodThatShouldRunned = {0,1,1,0,1,1};
    assertArrayEquals(methodsRuned, methodThatShouldRunned);
  }

  @Test
  public void whenInvokeLevelIsHeightAndNoPrivateAccessIsSetOnTrueThenAllMethodRun() {
    reflectionScanner = new ReflectionScannerV2(ReflectionScannerV2TestObject.class.getPackageName(),InvokeLevel.HIGH,true);
    reflectionScanner.run();
    int[] methodsRuned = ReflectionScannerV2TestObject.testy;
    int[] methodThatShouldRunned = {0,0,1,0,0,1};
    assertArrayEquals(methodsRuned, methodThatShouldRunned);
  }

}
