public class GeradorSenha implements Runnable {
  private int id;
  
  public GeradorSenha(int id) {
    this.id = id;
  }
  
  @Override
  public void run() {
    for(int i =0; i<100;i++) {
      Integer thread_senha = Contador.getInstance().getUpNumber();
      System.out.println(this.id+";s-"+thread_senha);
    }
    

  }

}
