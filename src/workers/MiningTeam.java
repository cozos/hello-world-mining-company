package workers;

import java.util.ArrayList;
import java.util.List;

import util.GameOracle;
import bwapi.Unit;
import departments.Department;
import departments.IDepartment.Purpose;

public class MiningTeam extends Team {

  /*
   * 4-split Logic
   */
  List<Integer> minedMinerals = new ArrayList<>();
   
  public MiningTeam(Department department) {
    super(department);
  }

  public void init() {
    department.requestUnits(this, Purpose.GAMESTART, 1);
  }

  public void work() {
    for (Unit unit : members) {
      if (unit.isIdle()) {
        gatherClosestMineral(unit);
      }
    }
    minedMinerals.clear();
  }

  private Unit gatherClosestMineral(Unit unit) {
    Unit closestMineral = null;

    for (Unit mineral : GameOracle.getMinerals()) {
      if ((closestMineral == null || unit.getDistance(mineral) < unit.getDistance(closestMineral))
          && !minedMinerals.contains(mineral.getID())) {
        closestMineral = mineral;
      }
    }

    if (closestMineral != null) {
      unit.gather(closestMineral, false);
      minedMinerals.add(closestMineral.getID());
    }

    return closestMineral;
  }
}
