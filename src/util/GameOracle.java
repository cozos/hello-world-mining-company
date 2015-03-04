package util;

import java.util.ArrayList;
import java.util.List;

import bwapi.Game;
import bwapi.Player;
import bwapi.Unit;

public class GameOracle {
  private static Game game;
  private static Player player;
  
  public static void init(Game game, Player player){
    GameOracle.game = game;
    GameOracle.player = player;
  }
  
  public static List<Unit> getUnits() {
    return player.getUnits();
  }
  
  public static List<Unit> getVisibleEnemyUnits(){
    return game.enemy().getUnits();
  }
  
  public static List<Unit> getMinerals(){
    List<Unit> minerals = new ArrayList<>();
    for (Unit neutralUnit : game.neutral().getUnits()) {
      if (neutralUnit.getType().isMineralField()) {
        minerals.add(neutralUnit);
      }
    }
    return minerals;
  }
  
  public static List<Unit> getVespene(){
    List<Unit> vespene = new ArrayList<>();
    for (Unit neutralUnit : game.neutral().getUnits()) {
      if (neutralUnit.getType().isRefinery()) {
        vespene.add(neutralUnit);
      }
    }
    return vespene;
  }
  
}
