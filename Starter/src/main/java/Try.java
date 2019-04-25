package main;

import com.reflectionscanner.ReflectionScanner;

/**
 * @author Kacper Staszek
 */
class Try {

  public static void main(String[] args) {


    ReflectionScanner reflectionScanner = new ReflectionScanner();
    reflectionScanner.runEverythingWithRun(Try.class.getPackageName());

  }
}
