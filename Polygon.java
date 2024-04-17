//A polygon class that implements the ComparePoly interface.
//Polygons consist of an array of orderedPoints and an area value
//This class has functions for calculating the area of the Polygon, finding the shortest distance to the origin, and determining which of 2 polygons is smallest
//Completed 12/03/24 Matthew Sefton

class Polygon extends PlanarShape {

    private Point[] orderedPoints;   
    private double area;   

    //constructor
    public Polygon(Point[] pointArray){
        this.orderedPoints=pointArray;
        this.area=calculateArea();
    }

    //toString: outputs a string of the form: [point 0 point 1 ... point n-2 ]: area
    public String toString(){
        String polyString = "";
        
        polyString += "POLY=[";

        for (int i=0; i<orderedPoints.length-1; i++)
            polyString += orderedPoints[i].toString();
        
        polyString += "]: ";
        polyString += area;
  
        return polyString;
    }


    //Calculate area: uses the shoelace formula. 
    public double calculateArea(){
        double area = 0;

        for (int i=0; i<orderedPoints.length-1; i++)
            area += (orderedPoints[i+1].getX() + orderedPoints[i].getX())*(orderedPoints[i+1].getY() - orderedPoints[i].getY());
            
        area = Math.abs(area);
        area /= 2;
        area = Math.round(area * 100.0) / 100.0;
        return area;     
    }

    //Return shortest distance between the origin and one of the vertices on the polygon
    public double originDistance(){

        double distance = orderedPoints[0].distanceFromOrigin();
        double distanceToCheck;

        for (int i=1; i<orderedPoints.length-2; i++)
        {
            distanceToCheck = orderedPoints[i].distanceFromOrigin();
            if (distanceToCheck < distance)
                distance = distanceToCheck;
        }

        return distance; 
    }

}
