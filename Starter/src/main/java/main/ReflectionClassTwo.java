package main;

import ja.workshops.cleancodedojo.Run;

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

 /* @Run
  public void methodThree() {
    throw  new ArrayIndexOutOfBoundsException();
    }
*/

  }



