package helloworldminingcompany.main;
import helloworldminingcompany.departments.TrainingDepartment;
import helloworldminingcompany.departments.UnitDepartment;
import helloworldminingcompany.util.GameOracle;
import bwapi.*;
import bwta.BWTA;

public class HelloWorldMiningCompany extends DefaultBWListener{

    private Mirror mirror = new Mirror();

    private Game game;

    private Player self;
    
    private UnitDepartment unitDepartment;
    private TrainingDepartment trainingDepartment;

    public void run() {
        mirror.getModule().setEventListener(this);
        mirror.startGame();
    }

    @Override
    public void onUnitCreate(Unit unit){
        System.out.println("New unit " + unit.getType());
    }

    @Override
    public void onStart(){
        game = mirror.getGame();
        self = game.self();
        
        GameOracle.init(game, self);
        unitDepartment = new UnitDepartment();
        trainingDepartment = new TrainingDepartment();

        //Use BWTA to analyze map
        //This may take a few minutes if the map is processed first time!
        System.out.println("Analyzing map...");
        BWTA.readMap();
        BWTA.analyze();
        System.out.println("Map data ready");

    }

    @Override
    public void onFrame(){
      unitDepartment.work();
      trainingDepartment.work(); // TODO Refactor 
    }

    public static void main(String[] args){
        new HelloWorldMiningCompany().run();
    }
}