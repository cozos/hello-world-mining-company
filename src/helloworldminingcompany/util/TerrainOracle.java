package helloworldminingcompany.util;

import java.util.List;

import bwta.BWTA;
import bwta.BaseLocation;

/**
 * Wrapper around BWTA.
 */
public class TerrainOracle {
  
  public static void init(){
    //Use BWTA to analyze map
    //This may take a few minutes if the map is processed first time!
    System.out.println("Analyzing map...");
    BWTA.readMap();
    BWTA.analyze();
    System.out.println("Map data ready");
  }
  
  public static List<BaseLocation> getBaseLocations(){
    return BWTA.getBaseLocations();
  }
  
}
