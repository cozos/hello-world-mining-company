package planners;

import java.util.List;

import bwapi.Unit;

public interface IDepartment {
  
  public void recruit();
  public List<Unit> getUnits();
  public int getMinerals();
}
