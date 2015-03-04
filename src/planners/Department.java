package planners;

import java.util.List;

import bwapi.Game;
import bwapi.Player;
import bwapi.Unit;

public abstract class Department implements IDepartment{
  public Game game;
  public Player self;
  
  public Department(Game game, Player self) {
    this.game = game;
    this.self = self;
  }
  
  public abstract void recruit();

  public List<Unit> getUnits() {
    return self.getUnits();
  }
  
  public int getMinerals(){
    return self.minerals();
  }
}
