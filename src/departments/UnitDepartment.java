package departments;

import java.util.ArrayList;
import java.util.List;

import util.GameOracle;
import workers.MiningTeam;
import workers.Team;
import bureaucracy.Request;
import bureaucracy.Request.Purpose;
import bwapi.Unit;

public class UnitDepartment extends Department {
  private List<Team> teams;
  
  public UnitDepartment(){
    this.teams = new ArrayList<Team>();
    // TODO hard code it here? Config file?
    teams.add(new MiningTeam(this));
  }

  public void init() {
    for(Team team : teams){
      team.init();
    }
  }

  public void work(){
    processUnitRequests();
    for(Team team : teams){
      team.work();
    }
  }

  public List<Unit> getUnits() {
    List<Unit> allUnits = new ArrayList<>();
    for (Team team : teams){
      allUnits.addAll(team.getMembers());
    }
    return allUnits;
  }
  
  public void processUnitRequests(){
    while(!unitRequests.isEmpty()){
      Request request = unitRequests.poll();
      
      // Special Case, Mine right away
      if(request.getPurpose() == Purpose.GAMESTART){
        assignAllWorkers(request.getTeam());
      }
    }
  }
  
  // TODO Hopefully java passes objects by reference
  public void assignAllWorkers(Team team){
    for (Unit unit : GameOracle.getUnits()) {
      if (unit.getType().isWorker()) {
        team.assign(unit);
      }
    }
  }
}
