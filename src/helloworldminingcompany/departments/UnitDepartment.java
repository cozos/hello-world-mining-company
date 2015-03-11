package helloworldminingcompany.departments;

import helloworldminingcompany.workers.ITeam;
import helloworldminingcompany.workers.MiningTeam;

import java.util.ArrayList;
import java.util.List;

import bwapi.Unit;

public class UnitDepartment extends Department{
  private List<ITeam> teams;
  
  public UnitDepartment(){
    this.teams = new ArrayList<ITeam>();
    // TODO hard code it here? Config file?
    teams.add(new MiningTeam(this));
  }
  
  @Override
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
}
