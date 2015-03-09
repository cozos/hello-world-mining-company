package helloworldminingcompany.strategy;

import helloworldminingcompany.bureaucracy.requests.IRequest;

import java.util.ArrayList;
import java.util.List;

import bwapi.Unit;

public abstract class WorkingEntity extends FinancialEntity implements IWorkingEntity{
  protected List<Unit> members = new ArrayList<Unit>();
  protected List<IRequest> pendingRequests = new ArrayList<IRequest>();
  
  public abstract void work();
  
  public void assign(Unit unit){
    this.members.add(unit);
  }
  
  protected int getRemainingRequests(){
    List<IRequest> newPendingRequests = new ArrayList<IRequest>();
    for(IRequest request : pendingRequests){
      if (!request.isCompleted()){
        newPendingRequests.add(request);
      }
    }
    pendingRequests = newPendingRequests;
    return pendingRequests.size();
  }
  
}
