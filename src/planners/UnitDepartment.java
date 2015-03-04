package planners;

import java.util.ArrayList;
import java.util.List;

import workers.Team;
import workers.WorkerTeam;
import bwapi.Game;
import bwapi.Player;

public class UnitDepartment extends Department {
  private List<Team> teams;
  
  public UnitDepartment(Game game, Player self){
    super(game, self);
    this.teams = new ArrayList<Team>();
    teams.add(new WorkerTeam(this)); // hard code it here?
  }

  public void recruit() {
    for(Team team : teams){
      team.recruit();
    }
  }

  public void work(){
    for(Team team : teams){
      team.work();
    }
  }
}
