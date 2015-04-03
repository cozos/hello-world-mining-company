package helloworldminingcompany.util.PotentialField;

import bwapi.Position;

public class RejectPotentialField extends PotentialField {

    public RejectPotentialField(Position position, double radius){
        super(position, radius);
    }

    public Position getForceFromPosition(Position externalPosition){

        double deltax = this.position.getX() - externalPosition.getX();
        double deltay = this.position.getY() - externalPosition.getY();
        double distance = Math.sqrt(deltax*deltax + deltay*deltay);
        double theta = Math.atan2(deltay, deltax);

        boolean withinField = (distance < this.radius);
        boolean withinBoundary = (this.radius <= distance && distance <= this.radius + this.boundaryLength);
        boolean isOutside = distance > this.radius + this.boundaryLength;

        Position position = null;
        if (withinField || withinBoundary){
            double c = -this.scalingFactor * (this.boundaryLength - distance + this.radius);
            int x = (int) (c * Math.cos(theta));
            int y = (int) (c * Math.sin(theta));
            position = new Position(x, y);
        }else if (isOutside){
            position = new Position(0, 0);
        }

        return position;
    }
}
