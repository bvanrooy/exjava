import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class ExE01 {

	static Scanner scanner;


	public static void main(String[] args) {

		String firstName;
		String lastName;
		int age;
		int startAge;
		double startSalary;
		scanner = new Scanner(System.in);

		firstName = getInputStringFromUser("Enter firstname : ");
		lastName = getInputStringFromUser("Enter lastname : ");
		age = getInputIntegerFromUser("Enter age : ");
		startAge = getInputIntegerFromUser("Enter age at wich instructor started at Abis : ");
		startSalary = getInputDoubleFromUser("Enter start salary : ");

		scanner.close();

		printSalaryHistory(firstName, lastName, age, startAge, startSalary);


	}

	private static String getInputStringFromUser(String message) {
		String value;
		System.out.println(message);
		value = scanner.nextLine();
		return value;
	}

	private static int getInputIntegerFromUser(String message) {
		int value = 0;
		System.out.println(message);
		while (!scanner.hasNextInt()) {
			System.out.println("-- please enter a valid number");
			scanner.next();
		}
		value = scanner.nextInt();
		return value;

	}


	private static double getInputDoubleFromUser(String message) {
		double value = 0;
		System.out.println(message);
		while (!scanner.hasNextDouble()) {
			System.out.println("-- please enter a valid number (decimals allowed");
			scanner.next();
		}

		value = scanner.nextDouble();
		return value;

	}


	private static void printSalaryHistory(String firstName, String lastName, int currentAge, int startAge, double startSalary) {
		int seniority = 0;
		int age = startAge;
		double salaryAtAge = startSalary;
		String line;

		try (BufferedWriter bw = Files.newBufferedWriter(Paths.get("salaryhistory.txt"))) {
			while (age < currentAge) {
				line = "Salary of " + firstName + " " + lastName + " at " + age + " is " + salaryAtAge;
				System.out.println(line);
				bw.write(line + "\n");
				age += 5;
				seniority += 5;
				if (seniority <= 35) {
					salaryAtAge *= 1.03;
				} else {
					line = "Maximum salary reached";
					System.out.println(line);
					bw.write(line + "\n");
					break;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}