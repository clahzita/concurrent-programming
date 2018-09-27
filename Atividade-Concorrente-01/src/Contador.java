
public class Contador {
  
  private Integer numero = 0; 
  private static Contador uniqueInstance = new Contador();
  
  private Contador() {
  }

  public static Contador getInstance() {
      return uniqueInstance;
  }
  
  public Integer getNumero() {
    
    Integer senha = numero;
    numero++;
    return senha;

  }
}
