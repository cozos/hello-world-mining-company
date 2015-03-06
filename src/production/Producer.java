package production;

import strategy.WorkingEntity;
import departments.Department;

public abstract class Producer extends WorkingEntity implements IProducer {
  protected Department department;
  
  public Producer(Department department){
    this.department = department;
  }
}
