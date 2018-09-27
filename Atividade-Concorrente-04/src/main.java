import java.awt.Container;
import java.util.ArrayList;
import java.util.List;

public class main {

  public static void main(String[] args) throws InterruptedException {
    int numberOfThreads = 5;
    int maxSemPermits = 3;

    long tempoInicial = System.currentTimeMillis();


    final List<Thread> threads = new ArrayList<>(numberOfThreads);
    
    for (int i = 0; i < numberOfThreads; i++) {
      
      Runnable thread;
 
      if(i%2==0) {
        thread = new ConsumerThread(maxSemPermits,i);
      }else {
        thread = new ProducerThread(maxSemPermits,i);
      }
      
      Thread t = new Thread(thread);
      t.start();
      threads.add(t);

    }

    for (final Thread thread : threads) {
      thread.join();
    }

    System.out.println("contador: "+Contador.getInstance().getNumero());
      long finalTime = System.currentTimeMillis() - tempoInicial;
      System.out.println("Tempo: " + finalTime + " ms");
    

  }
}
