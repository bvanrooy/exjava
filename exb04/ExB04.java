import java.util.HashMap;
import java.util.Scanner; 

public class ExB04{

	public static void main(String[] args){
	
		String languageCode;
		final String OTHERLANGUAGE = "OTHER";
		HashMap<String,String> greetings=new HashMap<String,String>();

		greetings.put("NL","Goeiedag!");
		greetings.put("FR","Bonjour!");
		greetings.put("EN","Good day!");
		greetings.put("OTHER","Goeiedag, bonjour and good day!");
		

		Scanner scanner = new Scanner(System.in);
			
		System.out.println("Enter languageCode : ");
		languageCode=scanner.nextLine();
		
		switch(languageCode){
			case "NL":
			case "FR":
			case "EN":
				System.out.println(languageCode + " : " + greetings.get(languageCode.toUpperCase()));
				break;
			default:
				System.out.println(languageCode + " : " + greetings.get(OTHERLANGUAGE));
		}
	}
}