package helloworldminingcompany.base;

import helloworldminingcompany.strategy.WorkingEntity;

import java.util.List;

import bwapi.TilePosition;
import bwapi.Unit;

/**
 * @author Arwin
 * Represents a mining base. Used to optimize miners per base. (And maybe other stuff later)
 */
public class MiningBase extends WorkingEntity{
  
  /*
   * Type of base. We'll revisit this later.
   */
  public enum BaseType{
    MAIN,
    EXPANSION,
    HIDDEN,
    ISLAND
  }
  
  private TilePosition position;
  private BaseType type;
  
  public MiningBase(TilePosition position, BaseType type){
    this.position = position; 
    this.type = type;
  }

  @Override
  public void work() {
    // TODO Nothing for now.
  }

  public TilePosition getPosition() {
    return position;
  }

  public BaseType getType(){
    return type;
  }
  
}
