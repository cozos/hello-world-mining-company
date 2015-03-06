package workers;

import java.util.List;

import strategy.WorkingEntity;
import bwapi.Unit;
import departments.Department;

public abstract class Team extends WorkingEntity implements ITeam {
  protected Department department;
  
  public Team(Department department){
    this.department = department;
  }

  public List<Unit> getMembers(){
    return members;
  }
}
