

public class Contador {
  
  private int numero = 0;
    
  public synchronized int getNumero() {
    
    return numero++;

  }
  
  public void zerarContador() {
    numero = 0;
  }
}
