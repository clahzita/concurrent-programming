import java.util.concurrent.Semaphore;

public class ConsumerThread implements Runnable {

  private int id;
  private final Semaphore available;

  public ConsumerThread(int maxPermits, int id) {
    this.id = id;
    available = new Semaphore(maxPermits, true);
  }

  @Override
  public void run() {
    try {
      System.out.println(this.id + "C: esperando o recurso!");
      available.acquire();
      System.out.println(this.id + "C: peguei o recurso!");

      for (int i = 0; i < 5; i++) {
        System.out.println(
            this.id + "C: I'm consuming the counter..." + Contador.getInstance().getDownNumber());
      }
      // Now, allowing a context switch -- if possible.
      // for thread B to execute
      Thread.sleep(10);
    } catch (InterruptedException e) {
      System.out.println(e);
    }

    System.out.println(this.id + "C: to liberando o recurso");
    available.release();

  }

}
