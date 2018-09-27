import java.util.ArrayList;
import java.util.List;

public class NoVisibility {

  private static volatile boolean ready = false;
  private static int number;

  private static class ReaderThread extends Thread {
    private int id;
    
    public ReaderThread(int id) {
      this.id = id;
    }
    public void run() {
      while(!ready) {
        System.out.println(id);
      }
      Thread.yield();
      System.out.println(number);
    }
  }

  private static class WriterThread extends Thread {
    public void run() {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      number = 42;
      ready = true;
      
      //System.out.println(number);
   //   Thread.yield();
    }
  }

  public static void main(String[] args) {
    long tempoInicial = System.currentTimeMillis();
    final List<Thread> threads = new ArrayList<>();
    
    Thread t1 = new ReaderThread(1);
    t1.start();
    threads.add(t1);
    
    Thread t2 = new ReaderThread(2);
    t2.start();
    threads.add(t2);
    
    Thread t3 = new ReaderThread(3);
    t3.start();
    threads.add(t3);
    
    Thread t4 = new ReaderThread(4);
    t4.start();
    threads.add(t4);
    
    Thread t5 = new WriterThread();
    t5.start();
    threads.add(t5);

    number = 42;
    
    for (final Thread thread : threads) {
      try {
        thread.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    
    long finalTime =  System.currentTimeMillis()-tempoInicial;
    System.out.println("Tempo: "+finalTime+" ms");


  }

}
