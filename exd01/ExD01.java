import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner; 
import java.io.BufferedReader;
import java.io.IOException;

public class ExD01{

    static final double VATPERCENTAGE = 21;	
	
	public static void main(String[] args){
		  
		String title;
		int numberOfDays=0;
		double pricePerDay=0;
		boolean priorKnowledgeNeeded;
		ArrayList<String> instructors = new ArrayList<>();
        double totalPriceVatIncl;
		boolean inputOk=false;

		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter course title : ");
		title=scanner.nextLine();
		do{
			inputOk=true;
			try{
				System.out.println("Enter number of days : ");
				numberOfDays = Integer.parseInt(scanner.nextLine());
			}
			catch(NumberFormatException ex){
				inputOk=false;
				System.out.println("Please enter a valid number");
			}
		}while(!inputOk);

		do{
			inputOk=true;
			try{
			System.out.println("Enter price per day : ");
			pricePerDay = Double.parseDouble(scanner.nextLine());
			}
			catch(NumberFormatException ex){
				inputOk=false;
				System.out.println("Please enter a valid number");
			}
		}while(!inputOk);

		priorKnowledgeNeeded = true;

		instructors = getInstructorsFromFile();
		
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

	
	private static ArrayList<String> getInstructorsFromFile(){
		ArrayList<String> instructors = new ArrayList<>();
		try(BufferedReader br = new BufferedReader(new FileReader("instructors.txt"))) {
			String line = br.readLine();
			while (line != null) {
				instructors.add(line);
				line = br.readLine();
			}
		}
		catch(FileNotFoundException ex){
			System.out.println("\n\nERROR Instructor file not found\n\n");
			}
		catch(IOException ex){
			System.out.println("\n\nERROR Error reading instructor file\n\n");
			}

		return instructors;
	}
		
}