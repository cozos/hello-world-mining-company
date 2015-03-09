package helloworldminingcompany.bureaucracy.buildfactory;

import bwapi.Unit;
import bwapi.UnitType;

public abstract class BuildFactory implements IBuildFactory{
  protected Unit builder;
  protected UnitType unitType;
  
  public BuildFactory(UnitType unitType, Unit builder){
    this.unitType = unitType;
    this.builder = builder;
  }
  
  public abstract void build();

  public UnitType getUnitType(){
    return unitType;
  }

  public Unit getBuilder(){
    return builder;
  }
}
