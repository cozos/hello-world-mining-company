package helloworldminingcompany.bureaucracy.requests;

import helloworldminingcompany.strategy.IWorkingEntity;

public interface IRequest {
  public enum Purpose{
    GAMESTART,
    ECONOMY,
    SCOUT,
    BUILD,
    DEFEND,
    ATTACK,
    CRITICAL
  }
  
  public void approve();
  public void reject();
  public void setCompleted();
  public boolean isCompleted();
  public int getPriority();
  public void setPriority(int priority);
  public Purpose getPurpose();
  public void setPurpose(Purpose purpose);
  public IWorkingEntity getWorkingEntity();
  public void setWorkingEntity(IWorkingEntity workingEntity);
}
