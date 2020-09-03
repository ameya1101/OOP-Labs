import java.util.ArrayList;

public class UseCircle {
    public static void main(String[] args) {

        // Create three Circle objects using each of the constructors
        Circle circ1 = new Circle(2, 3, 4);
        Circle circ2 = new Circle(1, 8);
        Circle circ3 = new Circle();

        // Set field values for the object with no arguments
        circ3.setCenter(5, 6);
        circ3.setRadius(12);

        // Set the radius for the object with no radius
        circ2.setRadius(1);

        // Translate a circle
        circ1.translate(7, 11);

        ArrayList<Circle> circles = new ArrayList<Circle>();
        circles.add(circ1);
        circles.add(circ2);
        circles.add(circ3);
        
        // Iterate over the objects to print center, radius and area
        for(Circle circ : circles) {

            System.out.println("Circle " + (circles.indexOf(circ)+1));
            System.out.print("Center: ");
            circ.getCenter();
            System.out.println();
            System.out.println("Radius: "+ circ.getRadius());
            System.out.println("Area: "+ circ.area());
            System.out.println();

        }
        
    }
}
