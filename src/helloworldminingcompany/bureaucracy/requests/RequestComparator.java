package helloworldminingcompany.bureaucracy.requests;

import java.util.Comparator;

public class RequestComparator implements Comparator<IRequest>{
  
  public int compare(IRequest x, IRequest y){
      if (x.getPriority() < y.getPriority())
      {
          return -1;
      }
      if (x.getPriority() > y.getPriority())
      {
          return 1;
      }
      return 0;
  }
}
