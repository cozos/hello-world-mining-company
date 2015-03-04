package bureaucracy;

import java.util.Comparator;

public class RequestComparator implements Comparator<Request> {
  
  public int compare(Request x, Request y) {
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
