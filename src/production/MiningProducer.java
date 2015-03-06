package production;

import util.GameOracle;
import departments.Department;
import bureaucracy.UnitRequest;
import bureaucracy.Request.Purpose;
import bwapi.Unit;
import bwapi.UnitType;

public class MiningProducer extends Producer {
  
  private long DEFAULT_TIME_TO_QUEUE_SCV = 2000;
  
  public MiningProducer(Department department) {
    super(department);
  }
  
  @Override
  public void init(){
    UnitRequest requestInitialWorkers = new UnitRequest(this, Purpose.GAMESTART, 1, UnitType.Terran_SCV);
    department.requestUnits(requestInitialWorkers);
  }
  
  @Override
  public void work(){
    for (Unit commandCenter : GameOracle.getOwnedUnits(UnitType.Terran_Command_Center)) {
      System.out.println(commandCenter);
      System.out.println(commandCenter.isTraining());
      System.out.println(commandCenter.getRemainingTrainTime());
      if (!commandCenter.isTraining() || commandCenter.getRemainingTrainTime() < DEFAULT_TIME_TO_QUEUE_SCV) {
        commandCenter.train(UnitType.Terran_SCV);
      }
    }
  }
}
