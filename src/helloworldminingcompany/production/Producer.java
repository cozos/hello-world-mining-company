package helloworldminingcompany.production;

import helloworldminingcompany.departments.Department;
import helloworldminingcompany.strategy.WorkingEntity;

public abstract class Producer extends WorkingEntity implements IProducer{
  protected Department department;
  
  public Producer(Department department){
    this.department = department;
  }
}
