public class main {

  public static void main(String[] args)    {

    long tempoInicial = System.currentTimeMillis();

    for (int i = 0; i < 100; i++) {

      Runnable gerador = new GeradorSenha(i);
      Thread t = new Thread(gerador);
      t.start();
      
    }

    
    
  }
  
}
  