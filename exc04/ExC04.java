import java.util.Scanner; 

public class ExC04{

	static Scanner scanner;
	
	public static void main(String[] args){
			scanner = new Scanner(System.in);
			
			Scanner scanner = new Scanner(System.in);
			getAnswer();
			scanner.close();
	}
	
	
	public static void getAnswer(){
		String answer;
	
		System.out.println("Welcome");
		System.out.println("would you like to be greated again (y/n)");
		answer=scanner.nextLine();
		if(answer.trim().toUpperCase().equals("Y")){
				getAnswer();
		}
	}
}