package departments;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import strategy.IWorkingEntity;
import strategy.WorkingEntity;
import util.GameOracle;
import bureaucracy.Request;
import bureaucracy.RequestComparator;
import bureaucracy.ResourceRequest;
import bureaucracy.UnitRequest;
import bwapi.Unit;
import bwapi.UnitType;

public abstract class Department extends WorkingEntity implements IDepartment{

  // TODO Probably need something more advanced 
  PriorityQueue<UnitRequest> unitRequests;
   
  public Department() {
    Comparator<Request> comparator = new RequestComparator();
    unitRequests = new PriorityQueue<UnitRequest>(10, comparator);
  }
  
  public abstract void init();
  public abstract List<Unit> getUnits();
  
  public void assignAllToTeam(IWorkingEntity entity, UnitType unitType){
    for (Unit unit : GameOracle.getUnits()) {
      if (unit.getType() == unitType) {
        entity.assign(unit);
      }
    }
  }
  
  public void requestUnits(UnitRequest request){
    // TODO Amazing algorithm to figure out priority.
    int priority = request.getPriority(); 
    request.setPriority(priority);
    
    unitRequests.add(request);
  }
  
  public void requestFunds(ResourceRequest request){
    // TODO Amazing AI Algorithm
  }
}
