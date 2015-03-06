package strategy;

/**
 * A FinancialEntity is defined as a class that can spend minerals or vespene gas,
 * either through training, building, researching, upgrading, etc. 
 */
public interface IFinancialEntity {
  public int getMinerals();
  public int getVespene();
  public void takeMinerals(int amount);
  public void takeVespene(int amount);
  public void giveMinerals(int amount);
  public void giveVespene(int amount);
}
