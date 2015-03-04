package planners;

import java.util.ArrayList;
import java.util.List;

import bwapi.Game;
import bwapi.Player;
import bwapi.Unit;
import bwapi.UnitType;

public class BuildingDepartment extends Department{
  private List<Unit> buildings;
  
  public BuildingDepartment(Game game, Player self) {
    super(game, self);
    buildings = new ArrayList<>();
  }

  public void recruit() {
    for (Unit unit : self.getUnits()) {
      if (unit.getType().isBuilding()) {
        buildings.add(unit);
      }
    }
  }
  
  public void doShit(){
    for (Unit building : buildings){
      if (building.getType() == UnitType.Terran_Command_Center && getMinerals() >= 50) {
        building.train(UnitType.Terran_SCV);
      }
    }
  }
  
}
