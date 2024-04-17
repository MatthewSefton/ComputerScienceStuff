//A polygon class that implements the ComparePoly interface.
//Polygons consist of an array of orderedPoints and an area value
//This class has functions for calculating the area of the Polygon, finding the shortest distance to the origin, and determining which of 2 polygons is smallest
//Completed 12/03/24 Matthew Sefton

class SemiCircle extends PlanarShape {

    private Point centre;
    private Point perpToBase;
    private double r;
    private double area;   

    //constructor
    public SemiCircle(Point centre, Point perpToBase){
        this.centre=centre;
        this.perpToBase=perpToBase;
        this.r=calculateRadius();
        this.area=calculateArea();
    }

    public double calculateRadius()
    {
        double x2=perpToBase.getX();
        double x1=centre.getX();
        double y2=perpToBase.getY();
        double y1=centre.getY();

    return Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
    }

    //toString: outputs a string of the form: CIRC=[centre, radius]: area
    public String toString(){
        String string = "";
        string += "SEMI=[";
        string += centre.toString();
        string += " ";
        string += perpToBase.toString();
        string += "]: ";
        string += area;
        return string;
    }

    //Get area method
    public double getArea(){
        return area;
    }

    //Calculate area
    public double calculateArea(){
        area = (Math.PI*r*r)/2;
        area = Math.round(area * 100.0) / 100.0;
        return area;
    }

    //Return distance to origin (find shortest distance between centre, perpToBase, and the two extremity points)
    public double originDistance(){
   
        double shortestDistance;
        double distanceToCheck;
        
        //find the extremity points
        double x2= centre.getX() - Math.abs(centre.getY()-perpToBase.getY());
        double y2= centre.getY() + Math.abs(centre.getX()-perpToBase.getX());
        Point extremityPoint1= new Point(x2,y2);

        double x3= centre.getX() + Math.abs(centre.getY()-perpToBase.getY());
        double y3= centre.getY() - Math.abs(centre.getX()-perpToBase.getX());
        Point extremityPoint2= new Point(x3,y3);

        //find out which point is closest to the origin
        shortestDistance=centre.distanceFromOrigin();

        distanceToCheck=perpToBase.distanceFromOrigin();
        if (distanceToCheck < shortestDistance)         
            shortestDistance=distanceToCheck;
        distanceToCheck=extremityPoint1.distanceFromOrigin();
        if (distanceToCheck < shortestDistance)         
            shortestDistance=distanceToCheck;
        distanceToCheck=extremityPoint2.distanceFromOrigin();
        if (distanceToCheck < shortestDistance)         
                shortestDistance=distanceToCheck;
       
    return shortestDistance;
    }

}
