package helloworldminingcompany.departments;

import helloworldminingcompany.util.GameOracle;
import helloworldminingcompany.workers.ITeam;
import helloworldminingcompany.workers.MiningTeam;

import java.util.ArrayList;
import java.util.List;

import bwapi.Unit;
import bwapi.UnitType;

public class UnitDepartment extends Department{
  private List<ITeam> teams;
  private MiningTeam miningTeam;
  
  public UnitDepartment(){
    this.teams = new ArrayList<ITeam>();
    // TODO hard code it here? Config file?
    miningTeam = new MiningTeam(this);
    teams.add(miningTeam);
  }
  
  @Override
  public void work(){
    processUnitRequests();

    // Probably shouldn't hard code like this, we'll refactor later.
    for(Unit unit: GameOracle.getUnassignedUnits()){
      if (unit.getType() == UnitType.Terran_SCV){
        miningTeam.assign(unit);
      }
    }
    
    for(ITeam team : teams){
      team.work();
    }
  }
  
  @Override
  public List<Unit> getUnits() {
    List<Unit> allUnits = new ArrayList<>();
    for (ITeam team : teams){
      allUnits.addAll(team.getMembers());
    }
    return allUnits;
  }
}
