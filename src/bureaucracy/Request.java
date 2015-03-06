package bureaucracy;

import strategy.IWorkingEntity;

public class Request {
  private IWorkingEntity workingEntity;
  private Purpose purpose;
  private int priority;
  
  public enum Purpose{
    GAMESTART,
    MINE,
    SCOUT,
    BUILD,
    DEFEND,
    ATTACK,
    CRITICAL
  }
  
  public Request(IWorkingEntity workingEntity, Purpose purpose, int priority) {
    this.setWorkingEntity(workingEntity);
    this.setPurpose(purpose);
    this.setPriority(priority);
  }

  public int getPriority() {
    return priority;
  }

  public void setPriority(int priority) {
    this.priority = priority;
  }

  public Purpose getPurpose() {
    return purpose;
  }

  public void setPurpose(Purpose purpose) {
    this.purpose = purpose;
  }

  public IWorkingEntity getWorkingEntity() {
    return this.workingEntity;
  }

  public void setWorkingEntity(IWorkingEntity workingEntity) {
    this.workingEntity = workingEntity;
  }

}
