package helloworldminingcompany.bureaucracy.requests;

import helloworldminingcompany.strategy.IWorkingEntity;

public abstract class Request implements IRequest{
  protected IWorkingEntity workingEntity;
  protected Purpose purpose;
  protected int priority;
  protected boolean completed = false;
  
  public Request(IWorkingEntity workingEntity, Purpose purpose, int priority){
    this.setWorkingEntity(workingEntity);
    this.setPurpose(purpose);
    this.setPriority(priority);
  }

  public abstract void approve();
  
  public void reject(){
    setCompleted();
  }
  
  public void setCompleted(){
    this.completed = true;
  }
  
  public boolean isCompleted(){
    return completed;
  }
  
  public int getPriority(){
    return priority;
  }

  public void setPriority(int priority){
    this.priority = priority;
  }

  public Purpose getPurpose(){
    return purpose;
  }

  public void setPurpose(Purpose purpose){
    this.purpose = purpose;
  }

  public IWorkingEntity getWorkingEntity(){
    return this.workingEntity;
  }

  public void setWorkingEntity(IWorkingEntity workingEntity){
    this.workingEntity = workingEntity;
  }

}
