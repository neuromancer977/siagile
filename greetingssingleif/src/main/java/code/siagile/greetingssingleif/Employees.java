package code.siagile.greetingssingleif;

import java.util.*;

/** 
 * create employe
 * 
 * @author Luca Marrocco
 */
public class Employees {

	public static Employee createNewFrom(String string) {
		return new Employees().createNew(string);
	}

	private Scanner scanner;

	private Employee employee;
	
	private String birthDay() {
		return scanner.next();
	}

	private void createEmployee() {
		employee = createEmployee(firstName(), lastName(), birthDay(), email());
	}

	private Employee createEmployee(String firstName, String lastName, String birthDay, String email) {
		return new Employee(firstName, lastName, birthDay, email);
	}

	private Employee createNew(String string) {
		prepareScannerFor(string);
		createEmployee();
		return employee;
	}

	private String email() {
		return scanner.next();
	}

	private String firstName() {
		return scanner.next();
	}

	private String lastName() {
		return scanner.next();
	}

	private void prepareScannerFor(String string) {
		scanner = new Scanner(string).useDelimiter(",");
	}

}