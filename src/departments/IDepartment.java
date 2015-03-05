package departments;

import java.util.List;

import workers.Team;
import bureaucracy.ResourceRequest;
import bureaucracy.UnitRequest;
import bwapi.Unit;

public interface IDepartment {
  public void init();
  public List<Unit> getUnits();
  public void requestFunds(Team team, ResourceRequest resourceRequest);
  public void requestUnits(Team team, UnitRequest unitRequest);
}
