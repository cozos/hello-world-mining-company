package departments;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import strategy.FinancialEntity;
import workers.Team;
import bureaucracy.Request;
import bureaucracy.RequestComparator;
import bwapi.Unit;

public abstract class Department extends FinancialEntity implements IDepartment{

  // TODO Probably need something more advanced 
  PriorityQueue<Request> unitRequests;
   
  public Department() {
    Comparator<Request> comparator = new RequestComparator();
    unitRequests = new PriorityQueue<Request>(10, comparator);
  }
  
  public abstract void init();
  public abstract List<Unit> getUnits();
  
  public void requestUnits(Team team, Purpose purpose, int prioritySuggestion){
    int priority = 1; // TODO Amazing algorithm to figure out priority.
    Request request = new Request(team, purpose, priority);
    unitRequests.add(request);
  }
  
  public void requestFunds(Team team, Purpose purpose,int minerals, int vespene, int prioritySuggestion){
    // TODO Amazing AI Algorithm
  }
}
