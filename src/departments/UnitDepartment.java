package departments;

import java.util.ArrayList;
import java.util.List;

import workers.ITeam;
import workers.MiningTeam;
import bureaucracy.Request.Purpose;
import bureaucracy.UnitRequest;
import bwapi.Unit;

public class UnitDepartment extends Department {
  private List<ITeam> teams;
  
  public UnitDepartment(){
    this.teams = new ArrayList<ITeam>();
    // TODO hard code it here? Config file?
    teams.add(new MiningTeam(this));
  }

  public void init() {
    for(ITeam team : teams){
      team.init();
    }
  }

  public void work(){
    processUnitRequests();
    for(ITeam team : teams){
      team.work();
    }
  }

  public List<Unit> getUnits() {
    List<Unit> allUnits = new ArrayList<>();
    for (ITeam team : teams){
      allUnits.addAll(team.getMembers());
    }
    return allUnits;
  }
  
  public void processUnitRequests(){
    while(!unitRequests.isEmpty()){
      UnitRequest request = unitRequests.poll();
      
      // Special Case, tell all workers to start mining on game start.
      if(request.getPurpose() == Purpose.GAMESTART){
        assignAllToTeam(request.getWorkingEntity(), request.getUnitType());
      }
    }
  }
}
