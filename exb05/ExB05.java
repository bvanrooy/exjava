import java.util.Scanner; 

public class ExB05{

	public static void main(String[] args){
			
			String answer;
			
			Scanner scanner = new Scanner(System.in);
			

			do{
				System.out.println("Welcome");
				System.out.println("would you like to be greated again (y/n)");
				answer=scanner.nextLine();
			} while(answer.trim().toUpperCase().equals("Y"));
	}
}