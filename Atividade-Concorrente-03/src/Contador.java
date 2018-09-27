
public class Contador {
  
  private int numero = 0;
  
  private static Contador uniqueInstance = new Contador();
  
  private Contador() {
  }

  public static Contador getInstance() {
      return uniqueInstance;
  }
  
  public int getNumero() {
    
    return numero++;

  }
  
  public void zerarContador() {
    numero = 0;
  }
}
