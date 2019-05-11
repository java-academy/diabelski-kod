package com.reflectionscanner;

import com.InvokeLevel;
import com.Run;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * @author Jakub Czajka
 */
class ReflectionScannerV2TestObject {
static int[] testy;

  @Run(invokeLevel = InvokeLevel.LOW)
  private void privateMethod1(){
    testy[3] = testy[3] +1;
  }

  @Run(invokeLevel = InvokeLevel.MEDIUM)
  private void privateMethod2(){
    testy[4] = testy[4] +1;
  }

  @Run(invokeLevel = InvokeLevel.HIGH)
  private void privateMethod3(){
    testy[5] = testy[5] +1;
  }

  @Run(invokeLevel = InvokeLevel.LOW)
  public void publicMethod1(){
     testy[0] = testy[0] +1;
  }

  @Run(invokeLevel = InvokeLevel.MEDIUM)
  public void publicMethod2(){
    testy[1] = testy[1] +1;
  }

  @Run(invokeLevel = InvokeLevel.HIGH)
  public void publicMethod3(){
    testy[2] = testy[2] +1;
  }

}
