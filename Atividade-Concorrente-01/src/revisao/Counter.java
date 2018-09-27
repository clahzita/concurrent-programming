package revisao;

public class Counter {
  private int value;
  
  public Counter(int n) {
    value = n;
  }
  
  public int getNext() {
    return value++;
  }

}
