package bureaucracy;

import workers.Team;

public class UnitRequest extends Request{

  public UnitRequest(Team team, Purpose purpose, int priority) {
    super(team, purpose, priority);
  }

}
