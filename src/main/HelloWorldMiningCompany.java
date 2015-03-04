package main;
import planners.BuildingDepartment;
import planners.UnitDepartment;
import bwapi.*;
import bwta.BWTA;

public class HelloWorldMiningCompany extends DefaultBWListener {

    private Mirror mirror = new Mirror();

    private Game game;

    private Player self;
    
    private UnitDepartment unitDepartment;
    private BuildingDepartment buildingDepartment;

    public void run() {
        mirror.getModule().setEventListener(this);
        mirror.startGame();
    }

    @Override
    public void onUnitCreate(Unit unit) {
        System.out.println("New unit " + unit.getType());
    }

    @Override
    public void onStart() {
        game = mirror.getGame();
        self = game.self();
        
        unitDepartment = new UnitDepartment(game, self);
        unitDepartment.recruit();
        
        buildingDepartment = new BuildingDepartment(game, self);
        buildingDepartment.recruit();
        

        //Use BWTA to analyze map
        //This may take a few minutes if the map is processed first time!
        System.out.println("Analyzing map...");
        BWTA.readMap();
        BWTA.analyze();
        System.out.println("Map data ready");

    }

    @Override
    public void onFrame() {
      unitDepartment.work();
      buildingDepartment.doShit(); // Refactor 
    }

    public static void main(String[] args) {
        new HelloWorldMiningCompany().run();
    }
}