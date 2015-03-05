package workers;

import java.util.ArrayList;
import java.util.List;

import strategy.FinancialEntity;
import departments.Department;
import bwapi.Unit;

public abstract class Team extends FinancialEntity implements ITeam {
  protected Department department;
  protected List<Unit> members;
  
  public Team(Department department){
    this.members = new ArrayList<>();
    this.department = department;
  }
  
  public abstract void init();
  public abstract void work();
  
  public void assign(Unit unit){
    this.members.add(unit);
  }
  
  public List<Unit> getMembers(){
    return members;
  }
}
