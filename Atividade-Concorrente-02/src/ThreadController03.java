
public class ThreadController03 implements Lock {
  int turn = 0;
  
  @Override
  public void requestCS(int pid) {
    while (turn == 1-pid);

  }

  @Override
  public void releaseCS(int pid) {
   turn = 1 - pid;

  }

}
