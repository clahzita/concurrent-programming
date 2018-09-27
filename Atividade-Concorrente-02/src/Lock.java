
public interface Lock {
  public void requestCS(int pid);
  public void releaseCS(int pid);
}
