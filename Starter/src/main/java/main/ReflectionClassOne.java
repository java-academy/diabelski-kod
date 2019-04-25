import com.Run;

/**
 * @author Kacper Staszek
 */
class ReflectionClassOne {
  @Run
  void methodOne(){
    System.out.println(this.getClass().getName()+" methodOne");
  }

}
