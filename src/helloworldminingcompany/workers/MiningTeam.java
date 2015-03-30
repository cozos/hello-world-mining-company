package helloworldminingcompany.workers;

import helloworldminingcompany.base.MiningBase;
import helloworldminingcompany.bureaucracy.requests.IRequest.Purpose;
import helloworldminingcompany.bureaucracy.requests.UnitRequest;
import helloworldminingcompany.departments.Department;
import helloworldminingcompany.util.GameOracle;

import java.util.ArrayList;
import java.util.List;

import bwapi.Unit;
import bwapi.UnitType;

public class MiningTeam extends Team{

  /*
   * 4-split Logic
   */
  private boolean init = false;
  private List<MiningBase> miningBases = new ArrayList<>();
   
  public MiningTeam(Department department){
    super(department);
    UnitRequest requestInitialWorkers = new UnitRequest(this, Purpose.GAMESTART, 1, UnitType.Terran_SCV);
    department.requestUnits(requestInitialWorkers);
  }
  
  @Override
  public void work(){
    if (!init) {
      doFourSplit();
      init = true;
    }
    
    tellIdleWorkersToMine();
  }

  @Override
  public void assign(Unit unit){
    this.members.add(unit);
    
    // Figure out which base we want to put the worker on.
    miningBases = GameOracle.getPlayerBases();
    miningBases.get(0).assign(unit);
  }
  
  private void tellIdleWorkersToMine(){
    for (Unit unit : members) {
      if (unit.isIdle()) {
        gatherClosestMineral(unit);
      }
    }
  }
  
  private void doFourSplit(){
    List<Integer> minedMinerals = new ArrayList<>();
    for (Unit unit : members) {
      if (unit.isIdle()) {
        minedMinerals.add(gatherClosestMineral(unit, minedMinerals).getID());;
      }
    }
    minedMinerals.clear();
  }
  
  private Unit gatherClosestMineral(Unit unit){
    return(gatherClosestMineral(unit, new ArrayList<Integer>()));
  }
  
  private Unit gatherClosestMineral(Unit unit, List<Integer> noMineList){
    Unit closestMineral = null;

    for (Unit mineral : GameOracle.getMapMinerals()) {
      if ((closestMineral == null || unit.getDistance(mineral) < unit.getDistance(closestMineral))
          && !noMineList.contains(mineral.getID())) {
        closestMineral = mineral;
      }
    }

    if (closestMineral != null) {
      unit.gather(closestMineral, false);
      
    }

    return closestMineral;
  }
}
