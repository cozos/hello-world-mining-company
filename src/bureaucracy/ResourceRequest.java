package bureaucracy;

import strategy.WorkingEntity;

public class ResourceRequest extends Request{
  int minerals;
  int vespene;
  
  public ResourceRequest(WorkingEntity workingEntity, Purpose purpose, int priority, int minerals, int vespene) {
    super(workingEntity, purpose, priority);
    this.minerals = minerals;
    this.vespene = vespene;
  }

}
