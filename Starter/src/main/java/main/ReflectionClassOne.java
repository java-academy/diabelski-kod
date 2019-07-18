package main;

import ja.workshops.cleancodedojo.Run;

/**
 * @author Kacper Staszek
 */
public class ReflectionClassOne {

  @Run
  public void methodOne(){
    System.out.println(this.getClass().getName()+" methodOne");
  }

  @Run
  private void privateMethod(){
    System.out.println("Run private");
  }

}
