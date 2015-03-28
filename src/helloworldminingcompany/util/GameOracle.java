package helloworldminingcompany.util;

import helloworldminingcompany.strategy.IWorkingEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import bwapi.Game;
import bwapi.Player;
import bwapi.Unit;
import bwapi.UnitType;

/**
 * A global static class that acts as a wrapper for the BWAPI client.
 * It is our single source of truth.
 */
public class GameOracle {
  private static long DEFAULT_RESOURCE_UPDATE_INTERVAL = 10000;
  private static long DEFAULT_OWNED_UNITS_MAP_UPDATE_INTERVAL = 60;
  
  private static Game game;
  private static Player player;
  
  private static List<Unit> minerals = new ArrayList<>();
  private static List<Unit> vespene = new ArrayList<>();
  
  private static Map<UnitType, List<Unit>> ownedUnitsMap = new HashMap<>();
  private static Map<Unit, IWorkingEntity> unitAssignmentMap = new HashMap<>();
  
  private static long lastResourceUpdate;
  private static long lastOwnedUnitsUpdate;
  
  /**
   * This better be called at game start, or you get a null pointer :P 
   */
  public static void init(Game game, Player player){
    GameOracle.game = game;
    GameOracle.player = player;
  }
  
  public static List<Unit> getUnits(){
    return player.getUnits();
  }
  
  public static int getPlayerMinerals(){
    return player.minerals();
  }
  
  public static int getPlayerVespene(){
    return player.gas();
  }
  
  public static List<Unit> getVisibleEnemyUnits(){
    return game.enemy().getUnits();
  }
  
  public static boolean isUnitOwned(Unit unit){
    checkLastUnitMapsUpdate();
    List<Unit> unitList = ownedUnitsMap.get(unit.getType());
    
    if(unitList == null){
      return false;
    } else {
      return unitList.contains(unit);
    }
  }
  
  /**
   * Update "cached" list if needed. 
   * Get "cached" list of Units by UnitType.
   * 
   */
  public static List<Unit> getOwnedUnits(UnitType unitType){
    checkLastUnitMapsUpdate();
    return ownedUnitsMap.get(unitType);
  }
  
  public static List<Unit> getAssignedUnits(){
    checkLastUnitMapsUpdate();
    List<Unit> assignedUnits = new ArrayList<Unit>();
    
    for(Entry<Unit, IWorkingEntity> entry : unitAssignmentMap.entrySet()){
      if (entry.getValue() != null){
        assignedUnits.add(entry.getKey());
      }
    }
    
    return assignedUnits;
  }
  
  public static List<Unit> getUnassignedUnits(){
    checkLastUnitMapsUpdate();
    List<Unit> unassignedUnits = new ArrayList<Unit>();
    
    for(Entry<Unit, IWorkingEntity> entry : unitAssignmentMap.entrySet()){
      if (entry.getValue() == null){
        unassignedUnits.add(entry.getKey());
      }
    }
    
    return unassignedUnits;
  }
  
  /**
   * We store a map of the players units so BWAPI isn't queried every frame (23 frames a second)
   * Remark: Not sure if actually needed
   * 
   * KEY: UnitType
   * VALUE: List of Units that are that UnitType
   */
  public static void updateUnitMaps(){
    ownedUnitsMap.clear();
    List<Unit> playerUnits = player.getUnits();
    
    for (Unit unit : playerUnits){
      // ownedUnitsMap
      List<Unit> unitListInMap = ownedUnitsMap.get(unit.getType());
      if(unitListInMap != null){
        unitListInMap.add(unit);
        ownedUnitsMap.put(unit.getType(), unitListInMap);
      } else {
        ownedUnitsMap.put(unit.getType(), new ArrayList<>(Arrays.asList(unit)));
      }
      
      // unitAssignmentMap
      if (!unitAssignmentMap.containsKey(unit)){
        unitAssignmentMap.put(unit, null);
      }
    }
    
    // Do headcount for unitAssignmentMap i.e. remove dead units from our headcount
    for(Unit unit : unitAssignmentMap.keySet()){
      if (!playerUnits.contains(unit)){
        if(unitAssignmentMap.get(unit) != null){
          unitAssignmentMap.get(unit).discharge(unit);
        }
        unitAssignmentMap.remove(unit);
      }
    }
    
    lastOwnedUnitsUpdate = System.currentTimeMillis();
  }
  
  /**
   * Update "cached" list if time elapsed is longer than interval.
   */
  public static void checkLastUnitMapsUpdate(){
    if(System.currentTimeMillis() - lastOwnedUnitsUpdate > DEFAULT_OWNED_UNITS_MAP_UPDATE_INTERVAL){
      updateUnitMaps();
    }
  }
  
  public static List<Unit> getMapMinerals(){
    checkLastResourceUpdate();
    return minerals;
  }
  
  public static List<Unit> getMapVespene(){
    checkLastResourceUpdate();
    return vespene;
  }

  /**
   * Same deal with Resources (Minerals and Vespene) 
   */
  public static void updateResources(){
    minerals.clear();
    vespene.clear();
    for (Unit neutralUnit : game.neutral().getUnits()){
      if (neutralUnit.getType().isMineralField()) {
        minerals.add(neutralUnit);
      }
      if (neutralUnit.getType().isRefinery()){
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
