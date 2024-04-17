//A planarShape class that implements the ComparePoly interface.
//Polygons consist of an array of orderedPoints and an area value
//This class has functions for calculating the area of the Polygon, finding the shortest distance to the origin, and determining which of 2 polygons is smallest
//Completed 12/03/24 Matthew Sefton

abstract class PlanarShape implements Comparable<PlanarShape> {

    private double area;   
    public abstract String toString();          
    public abstract double calculateArea();     
    public abstract double originDistance();

    //Get area method
    public double getArea(){
        return area;
    }


    //CompareTo : compares the area and distance to origin of 2 shapes.
    //returns 1 if this comes before other, -1 if this does not come before other
    @Override
    public int compareTo(PlanarShape other){
            if (this.area < other.getArea() * 1.001 && this.area > other.getArea() * 0.999) { // The areas are within 0.1% of each other
                if (originDistance()<= other.originDistance())
                    return 1; //if this is closer to the origin, this comes first
                else
                    return -1;
                
            } else {     // The areas are not within 0.1% of each other
               
                if (this.area > other.getArea())
                    return 1;    //if this' area is greater, then this comes first
                else
                    return -1;           
            }

    }

}
