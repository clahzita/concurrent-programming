
public class ThreadController02 implements Lock {
  boolean wantCS[]= {false,false};
  
  @Override
  public void requestCS(int pid) {//entry protocol
    wantCS[pid] = true; //declare intent
    while(wantCS[1-pid]); //busy wait
  }

  @Override
  public void releaseCS(int pid) {
    wantCS[pid] = false;

  }

}
