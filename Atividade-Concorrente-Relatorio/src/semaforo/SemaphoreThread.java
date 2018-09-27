package semaforo;
public class SemaphoreThread extends Thread {
  private int pos;
  private SemaphoreCounter counter;
  private int counterCalls;
  
  
  public SemaphoreThread(int pos, SemaphoreCounter counter, int counterCalls) {
    this.pos = pos;
    this.counter = counter;
    this.counterCalls = counterCalls;
  }
  
  public void run() {
    for (int i = 0; i < counterCalls; i++) {
      try {
        //pega o recurso
        System.out.println(this.pos+";"+this.getId()+";"+counter.getNext());
      } catch (InterruptedException e1) {
        e1.printStackTrace();
      }
      //libera o recurso
      counter.releaseCounter();
      
      try {
        Thread.sleep(1);
      } catch (InterruptedException e) {}
      
    }
  }
  
  
}
