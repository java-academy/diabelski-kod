package main;

import com.Run;

/**
 * @author Kacper Staszek
 */
public class ReflectionClassOne {
  @Run
  private Integer a = 9;

  @Run
  public void methodOne(){
    System.out.println(this.getClass().getName()+" methodOne");
  }

}
