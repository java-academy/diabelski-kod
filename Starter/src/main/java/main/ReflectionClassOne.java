package main;

import com.Run;

/**
 * @author Kacper Staszek
 */
public class ReflectionClassOne {

  @Run
  public void methodOne(){
    System.out.println(this.getClass().getName()+" methodOne");
  }

  @Run
  void privateMethod(){
    System.out.println("Run private");
  }

}
