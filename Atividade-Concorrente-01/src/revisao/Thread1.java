package revisao;
public class Thread1 extends Thread {
  private Counter c;
  
  public Thread1(Counter c) {
    this.c = c;
  }
  
  public void run() {
    for (int i = 0; i < 1000; i++) {
      System.out.println(this.getId()+";"+c.getNext());
      try {
        Thread.sleep(1);
      } catch (InterruptedException e) {}
    }
  }
  
  
}
