package helloworldminingcompany.bureaucracy.requests;

import helloworldminingcompany.strategy.WorkingEntity;
import bwapi.UnitType;

public class UnitRequest extends Request{
  private UnitType unitType;
  
  public UnitRequest(WorkingEntity workingEntity, Purpose purpose, int priority, UnitType unitType){
    super(workingEntity, purpose, priority);
    this.unitType = unitType;
  }
  
  public UnitType getUnitType(){
    return this.unitType;
  }

  public void approve(){
    //TODO Give all units?
    this.completed = true;
  }
}
