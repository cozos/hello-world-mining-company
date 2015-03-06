package departments;

import java.util.ArrayList;
import java.util.List;

import production.IProducer;
import production.MiningProducer;
import bwapi.Unit;

public class TrainingDepartment extends Department {
  private List<Unit> trainingFacilities = new ArrayList<>();
  private List<IProducer> producers = new ArrayList<>();

  public TrainingDepartment() {
    super();
    // TODO hard code it here? Config file?
    producers.add(new MiningProducer(this));
  }

  @Override
  public void init() {
    for(IProducer producer : producers){
      producer.init();
    }
  }

  @Override
  public void work() {
    for(IProducer producer : producers){
      producer.work();
    }
  }

  public List<Unit> getUnits() {
    return trainingFacilities;
  }
}
