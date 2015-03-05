package bureaucracy;

import workers.Team;

public class Request {
  private Team team;
  private Purpose purpose;
  private int priority;
  
  public enum Purpose{
    GAMESTART,
    MINE,
    SCOUT,
    BUILD,
    DEFEND,
    ATTACK,
    CRITICAL
  }
  
  public Request(Team team, Purpose purpose, int priority) {
    this.setTeam(team);
    this.setPurpose(purpose);
    this.setPriority(priority);
  }

  public int getPriority() {
    return priority;
  }

  public void setPriority(int priority) {
    this.priority = priority;
  }

  public Purpose getPurpose() {
    return purpose;
  }

  public void setPurpose(Purpose purpose) {
    this.purpose = purpose;
  }

  public Team getTeam() {
    return team;
  }

  public void setTeam(Team team) {
    this.team = team;
  }

}
