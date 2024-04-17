//A polygon class that implements the ComparePoly interface.
//Polygons consist of an array of orderedPoints and an area value
//This class has functions for calculating the area of the Polygon, finding the shortest distance to the origin, and determining which of 2 polygons is smallest
//Completed 12/03/24 Matthew Sefton

class Circle extends PlanarShape {

    private Point centre;
    private double r;
    private double area;   

    //constructor
    public Circle(Point centre, double r){
        this.centre=centre;
        this.r=r;
        this.area=calculateArea();
    }

    //toString: outputs a string of the form: CIRC=[centre, radius]: area
    public String toString(){
        String circleString = "";
        circleString += "CIRC=[";
        circleString += centre.toString();
        circleString += " ";
        circleString += r;
        circleString += "]: ";
        circleString += area;
        return circleString;
    }

    //Get area method
    public double getArea(){
        return area;
    }

    //Calculate area
    public double calculateArea(){
        double a= Math.PI*r*r;
        a = Math.round(a * 100.0) / 100.0;
        return a;
    }

    //Return distance to origin (distance between centre and origin - radius)
    public double originDistance(){
        return centre.distanceFromOrigin() - r;
    }

}
