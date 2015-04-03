package helloworldminingcompany.util.PotentialField;

import bwapi.Position;

public class AttractPotentialField extends PotentialField {

    public AttractPotentialField(Position position, double radius){
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
        if (withinField){
            position = new Position(0, 0);
        }else if(withinBoundary){
            double c = this.scalingFactor * (distance - this.radius);
            int x = (int) (c * Math.cos(theta));
            int y = (int) (c * Math.sin(theta));
            position = new Position(x, y);
        }else if (isOutside){
            double c = this.scalingFactor * distance;
            int x = (int) (c * Math.cos(theta));
            int y = (int) (c * Math.sin(theta));
            position = new Position(x, y);
        }

        return position;
    }
}
