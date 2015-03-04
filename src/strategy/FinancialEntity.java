package strategy;

public class FinancialEntity extends Entity {

  public int minerals;
  public int vespene;
  
  public int getMinerals(){
    return this.minerals;
  }
  
  public int getVespene(){
    return this.vespene;
  }
  
  public void takeMinerals(int amount){
    this.minerals -= amount; 
  }
  
  public void takeVespene(int amount){
    this.minerals -= amount;
  }
  
  public void giveMinerals(int amount){
    this.minerals -= amount; 
  }
  
  public void giveVespene(int amount){
    this.vespene += vespene;
  }
}
