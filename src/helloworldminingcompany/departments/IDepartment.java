package helloworldminingcompany.departments;

import helloworldminingcompany.bureaucracy.requests.ResourceRequest;
import helloworldminingcompany.bureaucracy.requests.UnitRequest;
import helloworldminingcompany.strategy.IWorkingEntity;

import java.util.List;

import bwapi.Unit;

public interface IDepartment extends IWorkingEntity{
  public List<Unit> getUnits();
  public void requestFunds(ResourceRequest resourceRequest);
  public void requestUnits(UnitRequest unitRequest);
}
