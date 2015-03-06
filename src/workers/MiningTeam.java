package workers;

import java.util.ArrayList;
import java.util.List;

import util.GameOracle;
import bureaucracy.Request.Purpose;
import bureaucracy.UnitRequest;
import bwapi.Unit;
import bwapi.UnitType;
import departments.Department;

public class MiningTeam extends Team {

  /*
   * 4-split Logic
   */
  private boolean init = false;
   
  public MiningTeam(Department department) {
    super(department);
  }
  
  @Override
  public void init() {
    UnitRequest requestInitialWorkers = new UnitRequest(this, Purpose.GAMESTART, 1, UnitType.Terran_SCV);
    department.requestUnits(requestInitialWorkers);
  }

  @Override
  public void work() {
    if (!init) {
      doFourSplit();
      init = true;
    }
    
    tellIdleWorkersToMine();
  }

  private void tellIdleWorkersToMine() {
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
  
  private Unit gatherClosestMineral(Unit unit, List<Integer> noMineList) {
    Unit closestMineral = null;

    for (Unit mineral : GameOracle.getMinerals()) {
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
