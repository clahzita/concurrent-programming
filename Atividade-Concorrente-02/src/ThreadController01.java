
public class ThreadController01 implements Lock {
  boolean openDoor = true;
  
  @Override
  public void requestCS(int pid) {
    while(!openDoor) { //busy wait
      openDoor=false;
    }
    
  }

  @Override
  public void releaseCS(int pid) {
    openDoor = true;
    
  }
}
