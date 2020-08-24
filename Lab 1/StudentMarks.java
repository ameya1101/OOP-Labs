import java.util.Scanner;

/**
 * The class StudentMarks implements an application that calculates the highest
 * mark from the marks of students that are provided by the user and calculates the highest score.
 * The application also calculates and displays the marks obtained
 * by each student as a percentage of the highest.
 */

public class StudentMarks {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in); 
		int num = input.nextInt();				// Gets the number of students

		double marks[] = new double[num];		// Array to store the marks of all students
		double highest = 0.0;

		for(int i = 0; i < num; i++) {			// Loop to obtain the marks of each student 
			double temp = input.nextDouble();	// Obtains the marks of each student
			marks[i] = temp;
			if(temp >= highest) {				// Calculate the highest marks among all
				highest = temp;
			}
		}

		input.close();							// Close the input stream

		System.out.println("\nHighest is " + highest + "\n");
		System.out.println("Marks as percentage\n");

		for(int i = 0; i < num; i++) {
			System.out.println((int) (marks[i]*100/highest) + "\n");	//Display the relative percentages
		}
		
	}
}