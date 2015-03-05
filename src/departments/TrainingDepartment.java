package departments;

import java.util.ArrayList;
import java.util.List;

import util.GameOracle;
import bwapi.Unit;
import bwapi.UnitType;

public class TrainingDepartment extends Department {
  private List<Unit> trainingFacilities;

  public TrainingDepartment() {
    super();
    trainingFacilities = new ArrayList<>();
  }

  public void init() {
    for (Unit unit : GameOracle.getUnits()) {
      if (unit.getType().isBuilding()) {
        trainingFacilities.add(unit);
      }
    }
  }

  public void doShit() {
    for (Unit trainingFacility : trainingFacilities) {
      if (trainingFacility.getType() == UnitType.Terran_Command_Center && getMinerals() >= 50) {
        trainingFacility.train(UnitType.Terran_SCV);
      }
    }
  }

  public List<Unit> getUnits() {
    return trainingFacilities;
  }

}
