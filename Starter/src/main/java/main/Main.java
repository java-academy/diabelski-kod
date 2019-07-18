package main;

import ja.workshops.cleancodedojo.InvokeLevel;
import ja.workshops.cleancodedojo.reflectionscanner.ReflectionScannerV2;

/**
 * @author Kacper Staszek
 * @author Wojciech Makiela
 */
class Main {

    public static void main(String[] args) {
        ReflectionScannerV2 reflectionScannerV2 = new ReflectionScannerV2(Main.class.getPackageName(), InvokeLevel.LOW, true);
        reflectionScannerV2.run();
    }
}
