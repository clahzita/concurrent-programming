public class GeradorSenha implements Runnable {
  private int id;
  
  public GeradorSenha(int id) {
    this.id = id;
  }
  
  @Override
  public void run() {
    //long id = Thread.currentThread().getId(); 
    
    new ThreadController01().requestCS(this.id);
    Integer thread_senha = Contador.getInstance().getNumero();
    new ThreadController01().releaseCS(this.id);
    System.out.println(this.id+";s-"+thread_senha);

  }

}
