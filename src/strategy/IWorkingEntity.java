package strategy;

import bwapi.Unit;

/**
 * A WorkingEntity is defined as a class that issues commands to units, produces, etc 
 * and acts or plans every Starcraft frame. 
 */
public interface IWorkingEntity extends IFinancialEntity {
  public abstract void init();
  public abstract void work();
  public abstract void assign(Unit unit);
}
