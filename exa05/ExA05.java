import java.util.ArrayList;
import java.util.Scanner; 

public class ExA05{
	
	public static void main(String[] args){
		  
		String title;
		int numberOfDays;
		int pricePerDay;
		boolean priorKnowledgeNeeded;
		ArrayList<String> instructors = new ArrayList<>();
        double totalPriceVatIncl;
        final double VATPERCENTAGE = 21;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter course title : ");
		title=scanner.nextLine();
		System.out.println("Enter number of days : ");
		numberOfDays = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter price per day : ");
		pricePerDay = Integer.parseInt(scanner.nextLine());

		priorKnowledgeNeeded = false;

		instructors.add("Sandy Schillebeeckx");
		instructors.add("Luigi Instructore");
		
		totalPriceVatIncl = pricePerDay * numberOfDays + ((pricePerDay * numberOfDays) * VATPERCENTAGE / 100);

		System.out.println("Course");
        System.out.println("Title :  " + title);
        System.out.println("Number of days : " + numberOfDays);
        System.out.println("Price / day : " + pricePerDay);
        System.out.println("Total Price VAT Incl : " + totalPriceVatIncl);
        System.out.println("Prior knowledge needed : " + priorKnowledgeNeeded);
        System.out.println("Number of instructors : " + instructors.size());
        for (String instructorForCourse : instructors) {
            System.out.println("\nInstructor : " + instructorForCourse);
        }		
	}
}