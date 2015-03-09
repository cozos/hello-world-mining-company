package helloworldminingcompany.bureaucracy.requests;

import helloworldminingcompany.strategy.WorkingEntity;

public class ResourceRequest extends Request{
  int minerals;
  int vespene;
  
  public ResourceRequest(WorkingEntity workingEntity, Purpose purpose, int priority, int minerals, int vespene) {
    super(workingEntity, purpose, priority);
    this.minerals = minerals;
    this.vespene = vespene;
  }
  
  public void approve(){
    workingEntity.giveMinerals(minerals);
    workingEntity.giveVespene(vespene);
    this.completed = true;
  }
  
}
