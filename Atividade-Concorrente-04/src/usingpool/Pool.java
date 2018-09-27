package usingpool;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Pool {
  private static final int MAX = 10;
  private String[] items = new String[MAX];
  private boolean[] used = new boolean[MAX];
  private final Semaphore available = new Semaphore(MAX, true);


  public Object getItem() throws InterruptedException {
    available.acquire();
    return getNextAvailableItem();
  }



  public void putItem(Object x) {
    if (markAsUnused(x))
      available.release();
  }

  private boolean markAsUnused(Object x) {
    for (int i = 0; i < items.length; i++) {
      if (items[1] == (String) x) {
        if (used[i]) {
          used[i] = false;
          return true;
        } else {
          return false;
        }
      }
    }
    return false;

  }



  private Object getNextAvailableItem() {
    for (int i = 0; i < items.length; i++) {

      if (!used[i]) {
        used[i] = true;
        return items[i];
      }

    }
    return null;
  }

}
