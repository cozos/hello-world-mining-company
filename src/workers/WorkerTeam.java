package workers;

import planners.Department;
import bwapi.Unit;

public class WorkerTeam extends Team {
  
  public WorkerTeam(Department department){
    super(department);
  }

  public void recruit() {
    for (Unit unit : department.getUnits()) {
      if (unit.getType().isWorker()) {
        members.add(unit);
      }
    }    
  }
  
  public void work(){
    for (Unit unit : members) {
      if (unit.isIdle()){
        gatherClosestMineral(unit);
      }
    }
  }
  
  private Unit gatherClosestMineral(Unit unit) {
    Unit closestMineral = null;
    
    for (Unit neutralUnit : department.game.neutral().getUnits()) {
        if (neutralUnit.getType().isMineralField()) {
            if (closestMineral == null || unit.getDistance(neutralUnit) < unit.getDistance(closestMineral)) {
                closestMineral = neutralUnit;
            }
        }
    }
    
    if (closestMineral != null) {
      unit.gather(closestMineral, false);
    }
    
    return closestMineral;
  }
  
}
