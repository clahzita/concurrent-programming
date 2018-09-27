public class GeradorSenha implements Runnable {
  
  @Override
  public void run() {
    long id = Thread.currentThread().getId(); 
    while(true) {
      if (Thread.interrupted()) {
        System.out.println("I'm about to stop");
        return;
      }
      Integer thread_senha = Contador.getInstance().getNumero();
      System.out.println(id+";"+thread_senha);
    
   
    }
    
  }

}
