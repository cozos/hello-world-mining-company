package helloworldminingcompany.workers;

import helloworldminingcompany.strategy.IWorkingEntity;

import java.util.List;

import bwapi.Unit;

public interface ITeam extends IWorkingEntity{
  public List<Unit> getMembers();
}
