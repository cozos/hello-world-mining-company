package helloworldminingcompany.strategy;

import bwapi.Unit;

/**
 * A WorkingEntity is defined as a class that issues commands to units, produces, etc 
 * and acts or plans every Starcraft frame. 
 */
public interface IWorkingEntity extends IFinancialEntity{
  public void work();
  public void assign(Unit unit);
}
