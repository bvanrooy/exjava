import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class ExD02{

    static final double VATPERCENTAGE = 21;	
	
	public static void main(String[] args){
		  
		String title;
		int numberOfDays=0;
		double pricePerDay=0;
		boolean priorKnowledgeNeeded;
		ArrayList<String> instructors = new ArrayList<>();
        double totalPriceVatIncl;
		boolean inputOk=false;
		ArrayList<String> infoLines = new ArrayList<>();

		
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

		
		infoLines = getCourseInfo(title,numberOfDays,pricePerDay,totalPriceVatIncl,priorKnowledgeNeeded,instructors);
		printInfo(infoLines);
		writeInfoToFile(infoLines);
		

	
	}
	
	public static void printInfo(ArrayList<String> lines){
        for (String line : lines) {
            System.out.println(line);
        }		
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


	private static ArrayList<String> getInstructorsFromFile() {
		ArrayList<String> instructors = new ArrayList<>();
		try (BufferedReader br = Files.newBufferedReader(Paths.get("instructors.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				instructors.add(line);
			}
		} catch (FileNotFoundException ex) {
			System.out.println("\n\nERROR Instructor file not found\n\n");
		} catch (IOException ex) {
			System.out.println("\n\nERROR Error reading instructor file\n\n");
		}

		return instructors;
	}
	
	private static ArrayList<String>getCourseInfo(String title, int numberOfDays, double pricePerDay, double totalPriceVatIncl, boolean priorKnowledgeNeeded,ArrayList<String> instructors){
		ArrayList<String> lines = new ArrayList<>();
			
		lines.add("Course\n-----------------------------------");
        lines.add("Title :  " + title);
        lines.add("Number of days : " + numberOfDays);
        lines.add("Price / day : " + pricePerDay);
		lines.add("Total Price VAT Incl : " + totalPriceVatIncl);
		lines.add(getPriceCategory(totalPriceVatIncl));
        lines.add("Prior knowledge needed : " + priorKnowledgeNeeded);
        lines.add("Number of instructors : " + instructors.size());
        for (String instructorForCourse : instructors) {
            lines.add("\t\tInstructor : " + instructorForCourse);
        }		
		lines.add("\n-----------------------------------------------------------");

		return lines;
	}
	
	private static void writeInfoToFile(ArrayList<String> lines){
		try (BufferedWriter bw = Files.newBufferedWriter(Paths.get("courseinfo.txt"))){
			for(String line:lines){
				bw.write(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
		
}