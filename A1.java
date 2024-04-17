//A1: the start up of our program.
//Contains the main function which prompts the user to type in the file path of the file they wish to read.
//Contains the main logic for reading the file and printing the output to the screen. 
//Completed 17/03/2024 Matthew Sefton
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class A1 {

    //create a list and a sorted list
    static LinkedList<PlanarShape> linkedList = new LinkedList<>();
    static SortedLinkedList<PlanarShape> sortedLinkedList = new SortedLinkedList<>();

        //Main
    public static void main(String[] args) {
        String filePath;
        Scanner keyboard=new Scanner(System.in);

        if (args.length == 0)
        {
            System.out.println("Enter the file path:");
            filePath = keyboard.nextLine(); // Read the file path input by the user
        }
        else
            filePath = args[0];
        
            //Reading and processing file
            try (Scanner fileScanner = new Scanner(new File(filePath))) {
                while (fileScanner.hasNext()) {
                    String c = fileScanner.next();
                    
                    //Creating a new Polygon
                    if (c.equals("P"))
                    {
                        int vertices = fileScanner.nextInt();
                        
                        //create an array of points and populate with a number of points equal to vertices +1 (because the first point is always equal to last)
                        Point[] pointArray = new Point[vertices+1];
                        for (int i=0; i<vertices; i++)
                        {
                            double x= fileScanner.nextDouble();
                            double y=fileScanner.nextDouble();
                            Point point = new Point(x,y);
                            pointArray[i] = point;
                        }

                        pointArray[vertices]=pointArray[0]; 

                        //Now that we have populated our array with points, we create our polygon and prepend it to our list
                        Polygon poly = new Polygon(pointArray);
                        linkedList.append(poly);
                        sortedLinkedList.insertInOrder(poly);
                    }
                    
                    //Creating a new Circle
                    else if (c.equals("C"))
                    {
                        double x= fileScanner.nextDouble();
                        double y= fileScanner.nextDouble();
                        double r= fileScanner.nextDouble();

                        Point point = new Point(x,y);

                        Circle circle = new Circle(point, r);
                        linkedList.append(circle);
                        sortedLinkedList.insertInOrder(circle);
                    }

                    //Creating a new Semi-Circle
                    else if (c.equals("S"))
                    {
                        double x= fileScanner.nextDouble();
                        double y= fileScanner.nextDouble();
                        double x2= fileScanner.nextDouble();
                        double y2= fileScanner.nextDouble();

                        Point point = new Point(x,y);
                        Point point2 = new Point(x2,y2);

                        SemiCircle semiCircle = new SemiCircle(point, point2);
                        linkedList.append(semiCircle);
                       sortedLinkedList.insertInOrder(semiCircle);
                    }
                
                }
            } catch (FileNotFoundException e) { //File not found exception
                System.out.println("File not found: " + filePath);
            }

            //Print out the sorted/unsorted lists of polygons
            System.out.println("Unsorted List");
            System.out.println(linkedList.returnListAsString());
            System.out.println("Sorted List");
            System.out.println(sortedLinkedList.returnListAsString());
            //System.out.println("Sorted List");
            //linkedList.sortList();
            //System.out.println(linkedList.returnListAsString());
            
        }

}
