import java.util.ArrayList;
import java.util.Scanner; 

public class ExC02{

    static final double VATPERCENTAGE = 21;	
	
	public static void main(String[] args){
		  
		String title;
		int numberOfDays;
		double pricePerDay;
		boolean priorKnowledgeNeeded;
		ArrayList<String> instructors = new ArrayList<>();
        double totalPriceVatIncl;

		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter course title : ");
		title=scanner.nextLine();
		System.out.println("Enter number of days : ");
		numberOfDays = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter price per day : ");
		pricePerDay = Double.parseDouble(scanner.nextLine());

		priorKnowledgeNeeded = true;

		instructors.add("Sandy Schillebeeckx");
		instructors.add("Luigi Instructore");

		totalPriceVatIncl = calculateTotalPriceVATIncl(numberOfDays,pricePerDay,priorKnowledgeNeeded);
		
		printInfo(title,numberOfDays,pricePerDay,totalPriceVatIncl,priorKnowledgeNeeded,instructors);

	
	}
	
	public static void printInfo(String title, int numberOfDays, double pricePerDay, double totalPriceVatIncl, boolean priorKnowledgeNeeded,ArrayList<String> instructors){
		System.out.println("Course\n-----------------------------------");
        System.out.println("Title :  " + title);
        System.out.println("Number of days : " + numberOfDays);
        System.out.println("Price / day : " + pricePerDay);
		System.out.println("Total Price VAT Incl : " + totalPriceVatIncl);
		System.out.println(getPriceCategory(totalPriceVatIncl));
        System.out.println("Prior knowledge needed : " + priorKnowledgeNeeded);
        System.out.println("Number of instructors : " + instructors.size());
        for (String instructorForCourse : instructors) {
            System.out.println("\t\tInstructor : " + instructorForCourse);
        }		
		System.out.println("\n-----------------------------------------------------------");

	}
	
	private static String getPriceCategory(double price){
		if(price< 500){
			return "CHEAP";
		}
		else if(price > 499 && price < 1500){
			return "OK";
		}else{
			return "EXPENSIVE";
		}
	}
	
	private static double calculateTotalPriceVATIncl(int numberOfDays, double pricePerDay,boolean priorKnowledgeNeeded){
		double total = 0;
		total = pricePerDay * numberOfDays ;
		if(!(numberOfDays > 3 && priorKnowledgeNeeded)){
			total += ( total * VATPERCENTAGE / 100);
		}		
		return total;
	}		
		
}