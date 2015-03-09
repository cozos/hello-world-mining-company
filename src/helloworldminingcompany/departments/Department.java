package helloworldminingcompany.departments;

import helloworldminingcompany.bureaucracy.requests.BuildRequest;
import helloworldminingcompany.bureaucracy.requests.IRequest;
import helloworldminingcompany.bureaucracy.requests.RequestComparator;
import helloworldminingcompany.bureaucracy.requests.ResourceRequest;
import helloworldminingcompany.bureaucracy.requests.UnitRequest;
import helloworldminingcompany.strategy.IWorkingEntity;
import helloworldminingcompany.strategy.WorkingEntity;
import helloworldminingcompany.util.GameOracle;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import bwapi.Unit;
import bwapi.UnitType;

public abstract class Department extends WorkingEntity implements IDepartment{

  // TODO Probably need something more advanced 
  PriorityQueue<UnitRequest> unitRequests;
  PriorityQueue<BuildRequest> buildRequests;
   
  public Department() {
    Comparator<IRequest> comparator = new RequestComparator();
    unitRequests = new PriorityQueue<UnitRequest>(10, comparator);
    buildRequests = new PriorityQueue<BuildRequest>(10, comparator);
  }
  
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
  
  public void requestBuild(BuildRequest buildRequest){
    buildRequests.add(buildRequest);
  }
  
  public void processUnitRequests(){
    while(!unitRequests.isEmpty()){
      UnitRequest request = unitRequests.poll();
      
      // Special Case, tell all workers to start mining on game start.
      if(request.getPurpose() == IRequest.Purpose.GAMESTART){
        assignAllToTeam(request.getWorkingEntity(), request.getUnitType());
      }
    }
  }
  
  
}
