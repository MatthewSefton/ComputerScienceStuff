//A simple point class, with an x and y value. Can convert point to a string and measure the distance from the origin.
//Written by Matthew Sefton 10/03/2024 c3109982

class Point {

    private double x;
    private double y;

    //Constructor
    public Point (double x, double y)
    {
        this.x=x;
        this.y=y;
    }

    //String Converter
    public String toString()
    {
        return "(" + x + " , " + y + ")";
    }

    //calculate distance method
    public double distanceFromOrigin()
    {
        return Math.sqrt(x*x + y*y);
    }

    public double getX(){
        return x;        
    }

    public double getY(){
        return y;        
    }

}
