
public class PetersonAlgorithm implements Lock {
  boolean wantCS[] = {false, false};
  int turn = 1;
  
  @Override
  public void requestCS(int pid) {
    int j = 1-pid;
    wantCS[pid] = true;
    turn = j;
    while(wantCS[j]&&(turn==j));

  }

  @Override
  public void releaseCS(int pid) {
    wantCS[pid] = false;

  }

}
