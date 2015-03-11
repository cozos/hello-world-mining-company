package helloworldminingcompany.bureaucracy.buildfactory;

import bwapi.Unit;
import bwapi.UnitType;

/**
 * Build a structure using an SCV.
 *
 */
public class BuildWithWorker extends BuildFactory{
  
  public BuildWithWorker(UnitType building, Unit worker){
    super(building, worker);
  }
  
  public void build(){
    //TODO Building placement algorithm.
  }
}
