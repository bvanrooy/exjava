import java.util.HashMap;
import java.util.Scanner; 

public class ExA06{

	public static void main(String args[]){
		String month;
		Integer dayOfMonth;
		Integer daysLeftThisMonth;
		
		HashMap<String, Integer> monthsOfTheYear = new HashMap<String,Integer>();
		
		monthsOfTheYear.put("january",31);
		monthsOfTheYear.put("february",28);
		monthsOfTheYear.put("march",31);
		monthsOfTheYear.put("april",30);
		monthsOfTheYear.put("may",31);
		monthsOfTheYear.put("june",30);
		monthsOfTheYear.put("july",31);
		monthsOfTheYear.put("august",31);
		monthsOfTheYear.put("september",30);
		monthsOfTheYear.put("october",31);
		monthsOfTheYear.put("november",30);
		monthsOfTheYear.put("december",31);
		
		Scanner scanner = new Scanner(System.in);
			
		System.out.println("Enter month : ");
		month=scanner.nextLine();
		System.out.println("Enter day of month : ");
		dayOfMonth=Integer.parseInt(scanner.nextLine());
		
		daysLeftThisMonth = monthsOfTheYear.get(month) - dayOfMonth;
		
		System.out.println("There are " + daysLeftThisMonth + " days left in " + month);
	}
}