import java.util.ArrayList;

public class ExA04noclass{
	
	public static void main(String[] args){
		  
		String title;
		int numberOfDays;
		int pricePerDay;
		boolean priorKnowledgeNeeded;
		ArrayList<String> instructors = new ArrayList<>();
        double totalPriceVatIncl;
        final double VATPERCENTAGE = 21;

		title = args[0];
		numberOfDays = Integer.parseInt(args[1]);
		pricePerDay = Integer.parseInt(args[2]);
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