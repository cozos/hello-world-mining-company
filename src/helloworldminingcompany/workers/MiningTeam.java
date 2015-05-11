package helloworldminingcompany.workers;

import helloworldminingcompany.base.MiningBase;
import helloworldminingcompany.bureaucracy.requests.IRequest.Purpose;
import helloworldminingcompany.bureaucracy.requests.UnitRequest;
import helloworldminingcompany.departments.Department;
import helloworldminingcompany.util.GameOracle;

import java.util.ArrayList;
import java.util.List;

import bwapi.Unit;
import bwapi.UnitType;

public class MiningTeam extends Team{

  /*
   * 4-split Logic
   */
  private List<MiningBase> miningBases = new ArrayList<>();
   
  public MiningTeam(Department department){
    super(department);
    UnitRequest requestInitialWorkers = new UnitRequest(this, Purpose.GAMESTART, 1, UnitType.Terran_SCV);
    department.requestUnits(requestInitialWorkers);
    miningBases = GameOracle.getPlayerBases();
  }
  
  @Override
  public void work(){
    for(MiningBase miningBase : miningBases){
      miningBase.work();
    }
    
  }

  @Override
  public void assign(Unit unit){
    this.members.add(unit);
    
    // Figure out which base we want to put the worker on.
    // TODO How do we know when we expanded?
    // TODO Distribution algorithm
    miningBases.get(0).assign(unit);
  }
}
