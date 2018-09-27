public class GeradorSenha implements Runnable {
  private int id;
  
  public GeradorSenha(Integer id) {
    this.id = id;
  }
  
  @Override
  public void run() {
    for(int i =0; i<10000;i++) {
      Integer thread_senha = Contador.getInstance().getNumero();
      System.out.println(this.id+";s-"+thread_senha);
    }
    

  }

}
