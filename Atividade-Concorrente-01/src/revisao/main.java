package revisao;

public class main {

  public static void main(String[] args) {
    Counter c = new Counter(0);
    Thread t1 = new Thread1(c);
    t1.start();
    
    Thread t2 = new Thread1(c);
    t2.start();
    
    try {
      t1.join();
      t2.join();
    } catch (InterruptedException e) {
    }

  }

}
