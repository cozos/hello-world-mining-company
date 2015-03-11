package helloworldminingcompany.departments;

import helloworldminingcompany.bureaucracy.requests.BuildRequest;
import helloworldminingcompany.production.IProducer;
import helloworldminingcompany.production.MiningProducer;
import helloworldminingcompany.util.GameOracle;

import java.util.ArrayList;
import java.util.List;

import bwapi.Unit;

public class TrainingDepartment extends Department{
  private List<Unit> trainingFacilities = new ArrayList<>();
  private List<IProducer> producers = new ArrayList<>();

  public TrainingDepartment(){
    super();
    // TODO hard code it here? Config file?
    producers.add(new MiningProducer(this));
  }

  @Override
  public void work(){
    processUnitRequests();
    processBuildRequests();
    for(IProducer producer : producers){
      producer.work();
    }
  }

  public List<Unit> getUnits(){
    return trainingFacilities;
  }
  
  public void processBuildRequests(){
    List<BuildRequest> delayedRequests = new ArrayList<>();
    
    while(!buildRequests.isEmpty()){
      BuildRequest request = buildRequests.poll();
      if (request.getCostInMinerals() <= GameOracle.getPlayerMinerals()
          && request.getCostInVespene() <= GameOracle.getPlayerVespene()){
        request.approve();
      } else {
        delayedRequests.add(request);
      }
    }
    
    buildRequests.addAll(delayedRequests);
  }
}
