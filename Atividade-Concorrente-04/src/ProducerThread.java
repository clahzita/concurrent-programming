import java.util.concurrent.Semaphore;

public class ProducerThread implements Runnable {
  private int id;
  private final Semaphore available;

  public ProducerThread(int maxPermits, int id) {
    this.id = id;
    available = new Semaphore(maxPermits, true);
  }

  @Override
  public void run() {
    try {
      System.out.println(this.id + "P: esperando o recurso!");
      available.acquire();
      System.out.println(this.id + "P: peguei o recurso!");

      for (int i = 0; i < 5; i++) {
        System.out.println(
            this.id + "P: I'm producing the counter..." + Contador.getInstance().getUpNumber());
      }
      // Now, allowing a context switch -- if possible.
      // for thread B to execute
      Thread.sleep(10);
    } catch (InterruptedException e) {
      System.out.println(e);
    }

    System.out.println(this.id + "P: to liberando o recurso");
    available.release();

  }

}
