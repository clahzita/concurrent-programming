import java.util.Random;

public class main {

  
  public static void main(String[] args) {
    
    for (int i = 0; i < 40; i++) {
      Runnable gerador = new GeradorSenha();
      Thread t = new Thread(gerador);
      t.start();
      Random geradorMilis = new Random();
      Integer milis = geradorMilis.nextInt(101);
      
      try {
        Thread.sleep(milis);
        System.out.print(milis+"ms;");
        t.interrupt();

    } catch (InterruptedException ex) {
        // do nothing
      System.out.println("exceção!!");
    }
         
      
    }
    
    
    

  }

}
