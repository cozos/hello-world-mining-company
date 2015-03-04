package workers;

import java.util.ArrayList;
import java.util.List;

import planners.Department;
import bwapi.Unit;

public abstract class Team {
  protected Department department;
  protected List<Unit> members;
  
  public Team(Department department){
    this.members = new ArrayList<>();
    this.department = department;
  }
  
  public abstract void recruit();
  public abstract void work();
}
