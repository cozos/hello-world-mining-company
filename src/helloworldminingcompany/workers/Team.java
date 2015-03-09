package helloworldminingcompany.workers;

import helloworldminingcompany.departments.Department;
import helloworldminingcompany.strategy.WorkingEntity;

import java.util.List;

import bwapi.Unit;

public abstract class Team extends WorkingEntity implements ITeam{
  protected Department department;
  
  public Team(Department department){
    this.department = department;
  }

  public List<Unit> getMembers(){
    return members;
  }
}
