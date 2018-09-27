package syncronized;
import java.util.ArrayList;
import java.util.List;

public class MainSyncronized {

  public static void main(String[] args)    {
    int numberOfThreads = 20;
    long timeSum = 0;
    int run = 5;

    long tempoInicial = System.currentTimeMillis();
    
    while(run > 0) {
      final List<Thread> threads = new ArrayList<>(numberOfThreads);
      Contador contador = new Contador();
      for (int i = 0; i < numberOfThreads; i++) {

        Runnable gerador = new GeradorSenha(i, contador);
        Thread t = new Thread(gerador);
        t.start();
        threads.add(t);

      }

      for (final Thread thread : threads) {
        try {
          thread.join();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      
      run--;
      long finalTime =  System.currentTimeMillis()-tempoInicial;
      System.out.println("Tempo: "+finalTime+" ms");
      timeSum += finalTime;
    }
    
    long media = timeSum/5;
    System.out.println("media: "+media);
    
  }
}
