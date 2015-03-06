package bureaucracy;

import strategy.WorkingEntity;
import bwapi.UnitType;

public class UnitRequest extends Request{
  private UnitType unitType;
  
  public UnitRequest(WorkingEntity workingEntity, Purpose purpose, int priority, UnitType unitType) {
    super(workingEntity, purpose, priority);
    this.unitType = unitType;
  }
  
  public UnitType getUnitType(){
    return this.unitType;
  }

}
