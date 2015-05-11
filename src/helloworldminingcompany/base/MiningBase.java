package helloworldminingcompany.base;

import helloworldminingcompany.strategy.WorkingEntity;
import helloworldminingcompany.util.GameOracle;

import java.util.ArrayList;
import java.util.List;

import bwapi.TilePosition;
import bwapi.Unit;

/**
 * @author Arwin
 * Represents a mining base. Used to optimize miners per base. (And maybe other stuff later)
 */
public class MiningBase extends WorkingEntity{
  
  /*
   * Type of base. We'll revisit this later.
   */
  private boolean init = false;
  
  public enum BaseType{
    MAIN,
    EXPANSION,
    HIDDEN,
    ISLAND
  }
  
  private TilePosition position;
  private BaseType type;
  
  public MiningBase(TilePosition position, BaseType type){
    this.position = position; 
    this.type = type;
  }

  @Override
  public void work() {
    if (!init) {
      doFourSplit();
      init = true;
    }
    tellIdleWorkersToMine();
  }

  public TilePosition getPosition() {
    return position;
  }

  public BaseType getType(){
    return type;
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
