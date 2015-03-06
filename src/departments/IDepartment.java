package departments;

import java.util.List;

import strategy.IWorkingEntity;
import bureaucracy.ResourceRequest;
import bureaucracy.UnitRequest;
import bwapi.Unit;

public interface IDepartment extends IWorkingEntity {
  public void init();
  public List<Unit> getUnits();
  public void requestFunds(ResourceRequest resourceRequest);
  public void requestUnits(UnitRequest unitRequest);
}
