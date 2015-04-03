package helloworldminingcompany.util;

import bwapi.Position;

public class PotentialField {

    public enum Mode{ ATTRACT, REPEL };

    private Mode mode;

    private double radius;

    private Position position;

    private double scalingFactor;

    private double boundaryLength;

    public PotentialField(Position position, double radius, Mode mode){
        this.boundaryLength = boundaryLength;
        this.position = position;
        this.radius = radius;
        this.mode = mode;
    }

    public void toggle(){
        if(this.mode == Mode.REPEL){
            this.mode = Mode.ATTRACT;
        }else{
            this.mode = Mode.REPEL;
        }
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
