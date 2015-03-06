package workers;

import java.util.List;

import strategy.IWorkingEntity;
import bwapi.Unit;

public interface ITeam extends IWorkingEntity {
  public List<Unit> getMembers();
}
