package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bwapi.Game;
import bwapi.Player;
import bwapi.Unit;
import bwapi.UnitType;

public class GameOracle {
  private static long DEFAULT_RESOURCE_UPDATE_INTERVAL = 30000;
  private static long DEFAULT_OWNED_UNITS_MAP_UPDATE_INTERVAL = 1000;
  
  private static Game game;
  private static Player player;
  
  private static List<Unit> minerals = new ArrayList<>();
  private static List<Unit> vespene = new ArrayList<>();
  
  private static Map<UnitType, List<Unit>> ownedUnitsMap = new HashMap<>();
  
  private static long lastResourceUpdate;
  private static long lastOwnedUnitsUpdate;
  
  /**
   * This better be called at game start, or you get a null pointer :P 
   */
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
  
  /**
   * Update "cached" list if needed. 
   * Get "cached" list of Units by UnitType.
   * 
   */
  public static List<Unit> getOwnedUnits(UnitType unitType) {
    checkLastOwnedUnitsUpdate();
    return ownedUnitsMap.get(unitType);
  }
  
  /**
   * Update "cached" list if time elapsed is longer than interval.
   */
  public static void checkLastOwnedUnitsUpdate(){
    if(System.currentTimeMillis() - lastOwnedUnitsUpdate > DEFAULT_OWNED_UNITS_MAP_UPDATE_INTERVAL){
      updateOwnedUnitMap();
    }
  }
  
  /**
   * We store a map of the players units so BWAPI isn't queried every frame (23 frames a second)
   * 
   * KEY: UnitType
   * VALUE: List of Units that are that UnitType
   */
  public static void updateOwnedUnitMap(){
    ownedUnitsMap.clear();
    for (Unit unit : player.getUnits()) {
      List<Unit> unitListInMap = ownedUnitsMap.get(unit.getType());
      if(unitListInMap != null){
        unitListInMap.add(unit);
        ownedUnitsMap.put(unit.getType(), unitListInMap);
      } else {
        ownedUnitsMap.put(unit.getType(), new ArrayList<>(Arrays.asList(unit)));
      }
    }
    lastOwnedUnitsUpdate = System.currentTimeMillis();
  }
  
  public static List<Unit> getMinerals(){
    checkLastResourceUpdate();
    return minerals;
  }
  
  public static List<Unit> getVespene(){
    checkLastResourceUpdate();
    return vespene;
  }

  /**
   * Same deal with Resources (Mineralls and Vespene) 
   */
  public static void updateResources(){
    minerals.clear();
    vespene.clear();
    for (Unit neutralUnit : game.neutral().getUnits()) {
      if (neutralUnit.getType().isMineralField()) {
        minerals.add(neutralUnit);
      }
      if (neutralUnit.getType().isRefinery()) {
        vespene.add(neutralUnit);
      }
    }
    lastResourceUpdate = System.currentTimeMillis();
  }
  
  public static void checkLastResourceUpdate(){
    if(System.currentTimeMillis() - lastResourceUpdate > DEFAULT_RESOURCE_UPDATE_INTERVAL){
      updateResources();
    }
  }
}
