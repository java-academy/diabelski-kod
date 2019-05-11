package com.reflectionscanner;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;

import com.InvokeLevel;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author Jakub Czajka
 */
public class ReflectionScannerV2Test {

  ReflectionScannerV2 reflectionScanner;

  @BeforeMethod
  public void beforeEachMethod() {
    reflectionScanner = new ReflectionScannerV2(ReflectionScannerV2TestObject.class.getPackageName());
    ReflectionScannerV2TestObject.testy = new int[6];
  }

  @Test
  public void whenInvokeLevelIsLowAndNoPrivateAccessIsSetThenOnlyOneMethodRun() {
    reflectionScanner.setInvokeLevel(InvokeLevel.LOW).setPrivateAccess(false);
    reflectionScanner.run();
    int[] methodsRuned = ReflectionScannerV2TestObject.testy;
    int[] methodThatShouldRunned = {1,1,1,0,0,0};
    assertArrayEquals(methodsRuned, methodThatShouldRunned);
  }

  @Test
  public void whenInvokeLevelIsMediumAndNoPrivateAccessIsSetThenOnlyOneMethodRun() {
    reflectionScanner.setInvokeLevel(InvokeLevel.MEDIUM).setPrivateAccess(false);
    reflectionScanner.run();
    int[] methodsRuned = ReflectionScannerV2TestObject.testy;
    int[] methodThatShouldRunned = {0,1,1,0,0,0};
    assertArrayEquals(methodsRuned, methodThatShouldRunned);
  }
  @Test
  public void whenInvokeLevelIsHightAndNoPrivateAccessIsSetThenOnlyOneMethodRun() {
    reflectionScanner.setInvokeLevel(InvokeLevel.HIGH).setPrivateAccess(false);
    reflectionScanner.run();
    int[] methodsRuned = ReflectionScannerV2TestObject.testy;
    int[] methodThatShouldRunned = {0,0,1,0,0,0};
    assertArrayEquals(methodsRuned, methodThatShouldRunned);
  }

  @Test
  public void whenInvokeLevelIsLowAndNoPrivateAccessIsSetOnTrueThenAllMethodRun() {
    reflectionScanner.setInvokeLevel(InvokeLevel.LOW).setPrivateAccess(true);
    reflectionScanner.run();
    int[] methodsRuned = ReflectionScannerV2TestObject.testy;
    int[] methodThatShouldRunned = {1,1,1,1,1,1};
    assertArrayEquals(methodsRuned, methodThatShouldRunned);
  }

  @Test
  public void whenInvokeLevelIsMediumAndNoPrivateAccessIsSetOnTrueThenAllMethodRun() {
    reflectionScanner.setInvokeLevel(InvokeLevel.MEDIUM).setPrivateAccess(true);
    reflectionScanner.run();
    int[] methodsRuned = ReflectionScannerV2TestObject.testy;
    int[] methodThatShouldRunned = {0,1,1,0,1,1};
    assertArrayEquals(methodsRuned, methodThatShouldRunned);
  }

  @Test
  public void whenInvokeLevelIsHeightAndNoPrivateAccessIsSetOnTrueThenAllMethodRun() {
    reflectionScanner.setInvokeLevel(InvokeLevel.HIGH).setPrivateAccess(true);
    reflectionScanner.run();
    int[] methodsRuned = ReflectionScannerV2TestObject.testy;
    int[] methodThatShouldRunned = {0,0,1,0,0,1};
    assertArrayEquals(methodsRuned, methodThatShouldRunned);
  }

}
