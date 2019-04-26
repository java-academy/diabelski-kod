package main;

import com.Run;

/**
 * @author Kacper Staszek
 */
public class ReflectionClassTwo {

  @Run
  public void methodOne() {
    System.out.println(this.getClass().getName() + " methodOne");
  }

  @Run
  public void methodTwo() {
    System.out.println(this.getClass().getName() + " two");
  }


}
