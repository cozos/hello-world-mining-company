package helloworldminingcompany.util;

import bwta.BWTA;
import bwta.Polygon;
import bwta.Region;

import java.util.List;
import java.util.stream.Collectors;

public class BWTATranslator {
    public float[][] getPointsFromRegion(Region region){
        /**
         * JDK 8
        List<Polygon> polygons = BWTA
                .getRegions()
                .stream()
                .map(reg -> reg.getPolygon())
                .collect(Collectors.toList());
        Polygon p = polygons.get(0);
         */
        return null;
    }
}
