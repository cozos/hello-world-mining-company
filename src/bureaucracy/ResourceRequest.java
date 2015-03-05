package bureaucracy;

import workers.Team;

public class ResourceRequest extends Request{
  int minerals;
  int vespene;
  
  public ResourceRequest(Team team, Purpose purpose, int priority, int minerals, int vespene) {
    super(team, purpose, priority);
  }

}
