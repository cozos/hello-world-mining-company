package helloworldminingcompany.bureaucracy.buildfactory;

import bwapi.Unit;
import bwapi.UnitType;

/**
 * Train a unit from a building. 
 *
 */
public class BuildFromBuilding extends BuildFactory{
  
  public BuildFromBuilding(UnitType unitType, Unit builder){
    super(unitType, builder);
  }
  
  public void build(){
    builder.train(unitType);
  }
}
