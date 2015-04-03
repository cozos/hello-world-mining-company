package helloworldminingcompany.util.PotentialField;

import bwapi.Position;

public abstract class PotentialField {

    protected double radius;

    protected Position position;

    protected double scalingFactor;

    protected double boundaryLength;

    public PotentialField(Position position, double radius){
        this.boundaryLength = boundaryLength;
        this.position = position;
        this.radius = radius;
    }

    public abstract Position getForceFromPosition(Position externalPosition);
}
