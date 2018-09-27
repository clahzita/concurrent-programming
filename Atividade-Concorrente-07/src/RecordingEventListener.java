import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecordingEventListener extends EventListener {
  private final List<Integer> list;
  
  public RecordingEventListener(EventSource eventSource) {
    super(eventSource);
    list = Collections.synchronizedList(new ArrayList());
  }
  
  public void onEvent(Integer e) {
    list.add(e);
    super.onEvent(e);    
  }
  
  public List<Integer> getEvents() {
    return list;
  }

}
