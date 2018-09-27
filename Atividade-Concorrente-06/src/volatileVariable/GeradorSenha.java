package volatileVariable;
public class GeradorSenha implements Runnable {
  private int id;
  private Contador contador;
  
  public GeradorSenha(Integer id, Contador contador) {
    this.id = id;
    this.contador=contador;
  }
  
  @Override
  public void run() {
    for(int i =0; i<10000;i++) {
      
      
      System.out.println(this.id+";s-"+contador.getNumero());
    }
    

  }

}
