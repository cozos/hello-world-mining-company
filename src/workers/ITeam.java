package workers;

import bwapi.Unit;

public interface ITeam {
  
  public void init();
  public void work();
  public void assign(Unit unit);
}
