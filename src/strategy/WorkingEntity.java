package strategy;

import java.util.ArrayList;
import java.util.List;

import bwapi.Unit;

public abstract class WorkingEntity extends FinancialEntity implements IWorkingEntity {
  protected List<Unit> members = new ArrayList<Unit>();
  
  public abstract void init();
  public abstract void work();
  public void assign(Unit unit){
    this.members.add(unit);
  }
}
