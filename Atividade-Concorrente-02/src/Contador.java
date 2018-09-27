
public class Contador {
  
  private int numero = 0; 
  
  private static Contador uniqueInstance = new Contador();
  
  private Contador() {
  }

  public static Contador getInstance() {
      return uniqueInstance;
  }
  
  public Integer getNumero() {
    
   // Integer senha = numero;
    return numero++;

  }
}
