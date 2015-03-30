package helloworldminingcompany.main;
import helloworldminingcompany.departments.TrainingDepartment;
import helloworldminingcompany.departments.UnitDepartment;
import helloworldminingcompany.util.GameOracle;
import helloworldminingcompany.util.TerrainOracle;
import bwapi.DefaultBWListener;
import bwapi.Game;
import bwapi.Mirror;
import bwapi.Player;
import bwapi.Unit;

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
        TerrainOracle.init();
        unitDepartment = new UnitDepartment();
        trainingDepartment = new TrainingDepartment();
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