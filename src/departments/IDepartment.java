package departments;

import java.util.List;

import workers.Team;
import bwapi.Unit;

public interface IDepartment {
  public enum Purpose{
    GAMESTART,
    MINE,
    SCOUT,
    BUILD,
    DEFEND,
    ATTACK,
    CRITICAL
  }
  
  public void init();
  public List<Unit> getUnits();
  public void requestFunds(Team team, Purpose purpose,int minerals, int vespene, int Suggestion);
  public void requestUnits(Team team, Purpose purpose, int prioritySuggestion);
}
