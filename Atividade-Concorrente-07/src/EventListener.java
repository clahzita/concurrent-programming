
public class EventListener {
  
  public EventListener(EventSource eventSource) {
   eventSource.registerListener(this);
   
  }
  
  public void onEvent(int e) {
    System.out.println("evento"+e);
  }

}
