package helloworldminingcompany.bureaucracy.requests;

import helloworldminingcompany.bureaucracy.buildfactory.IBuildFactory;
import helloworldminingcompany.strategy.WorkingEntity;

public class BuildRequest extends Request{
  private IBuildFactory buildFactory;
  
  public BuildRequest(WorkingEntity workingEntity, Purpose purpose, int priority, IBuildFactory buildFactory) {
    super(workingEntity, purpose, priority);
    this.buildFactory = buildFactory;
  }
  
  public IBuildFactory getBuildFactory(){
    return this.buildFactory;
  }
  
  public void approve(){
    buildFactory.build();
    this.completed = true;
  }
  
  public int getCostInMinerals(){
    return buildFactory.getUnitType().mineralPrice();
  }
  
  public int getCostInVespene(){
    return buildFactory.getUnitType().gasPrice();
  }

}
