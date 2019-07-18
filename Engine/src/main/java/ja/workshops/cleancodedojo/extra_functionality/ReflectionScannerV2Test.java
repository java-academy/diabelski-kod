package ja.workshops.cleancodedojo.extra_functionality;

/**
 * @author Wojciech Makiela
 */
public class ReflectionScannerV2Test {

//  ReflectionScannerV2 reflectionScanner;
//
//  @BeforeMethod
//  public void beforeEachMethod() {
//    TestObject.testy = new int[6];
//  }
//
//  @Test
//  public void whenInvokeLevelIsLowAndNoPrivateAccessIsSetThenOnlyOneMethodRun() {
//    String packageName = TestObject.class.getPackageName();
//    System.out.println(packageName);
//    reflectionScanner = new ReflectionScannerV2(packageName,InvokeLevel.LOW,false);
//    reflectionScanner.run();
//    int[] methodsRuned = TestObject.testy;
//    int[] methodThatShouldRunned = {1,2,3,0,0,0};
//    assertArrayEquals(methodsRuned, methodThatShouldRunned);
//  }
//
//  @Test
//  public void whenInvokeLevelIsMediumAndNoPrivateAccessIsSetThenOnlyOneMethodRun() {
//    reflectionScanner = new ReflectionScannerV2(TestObject.class.getPackageName(),InvokeLevel.MEDIUM,false);
//    reflectionScanner.run();
//    int[] methodsRuned = TestObject.testy;
//    int[] methodThatShouldRunned = {0,2,3,0,0,0};
//    assertArrayEquals(methodsRuned, methodThatShouldRunned);
//  }
//  @Test
//  public void whenInvokeLevelIsHightAndNoPrivateAccessIsSetThenOnlyOneMethodRun() {
//    reflectionScanner = new ReflectionScannerV2(TestObject.class.getPackageName(),InvokeLevel.HIGH,false);
//    reflectionScanner.run();
//    int[] methodsRuned = TestObject.testy;
//    int[] methodThatShouldRunned = {0,0,3,0,0,0};
//    assertArrayEquals(methodsRuned, methodThatShouldRunned);
//  }
//
//  @Test
//  public void whenInvokeLevelIsLowAndNoPrivateAccessIsSetOnTrueThenAllMethodRun() {
//    reflectionScanner = new ReflectionScannerV2(TestObject.class.getPackageName(),InvokeLevel.LOW,true);
//    reflectionScanner.run();
//    int[] methodsRuned = TestObject.testy;
//    int[] methodThatShouldRunned = {1,2,3,4,5,6};
//    assertArrayEquals(methodsRuned, methodThatShouldRunned);
//  }
//
//  @Test
//  public void whenInvokeLevelIsMediumAndNoPrivateAccessIsSetOnTrueThenAllMethodRun() {
//    reflectionScanner = new ReflectionScannerV2(TestObject.class.getPackageName(),InvokeLevel.MEDIUM,true);
//    reflectionScanner.run();
//    int[] methodsRuned = TestObject.testy;
//    int[] methodThatShouldRunned = {0,2,3,0,5,6};
//    assertArrayEquals(methodsRuned, methodThatShouldRunned);
//  }
//
//  @Test
//  public void whenInvokeLevelIsHeightAndNoPrivateAccessIsSetOnTrueThenAllMethodRun() {
//    reflectionScanner = new ReflectionScannerV2(TestObject.class.getPackageName(),InvokeLevel.HIGH,true);
//    reflectionScanner.run();
//    int[] methodsRuned = TestObject.testy;
//    int[] methodThatShouldRunned = {0,0,3,0,0,6};
//    assertArrayEquals(methodsRuned, methodThatShouldRunned);
//  }
//
}
