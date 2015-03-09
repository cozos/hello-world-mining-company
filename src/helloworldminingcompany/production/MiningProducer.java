package helloworldminingcompany.production;

import helloworldminingcompany.bureaucracy.buildfactory.BuildFromBuilding;
import helloworldminingcompany.bureaucracy.requests.BuildRequest;
import helloworldminingcompany.bureaucracy.requests.IRequest.Purpose;
import helloworldminingcompany.bureaucracy.requests.Request;
import helloworldminingcompany.bureaucracy.requests.UnitRequest;
import helloworldminingcompany.departments.Department;
import bwapi.Unit;
import bwapi.UnitType;

public class MiningProducer extends Producer{
  
  private long DEFAULT_TIME_TO_QUEUE_SCV = 2;
  
  public MiningProducer(Department department){
    super(department);
    UnitRequest requestInitialCommandCenter = new UnitRequest(this, Purpose.GAMESTART, 1, UnitType.Terran_Command_Center);
    department.requestUnits(requestInitialCommandCenter);
  }
    
  @Override
  public void work(){
    for (Unit commandCenter : members){
      if ((!commandCenter.isTraining() || commandCenter.getRemainingTrainTime() < DEFAULT_TIME_TO_QUEUE_SCV)
          && getRemainingRequests() < members.size()){
        requestForSCV(commandCenter);
      }
    }
  }
  
  private void requestForSCV(Unit commandCenter){
    BuildFromBuilding buildSCV = new BuildFromBuilding(UnitType.Terran_SCV, commandCenter);
    BuildRequest buildRequest = new BuildRequest(this, Request.Purpose.ECONOMY, 1, buildSCV);
    pendingRequests.add(buildRequest);
    department.requestBuild(buildRequest);
    System.out.println("Requested to build another SCV.");
  }
  
}
