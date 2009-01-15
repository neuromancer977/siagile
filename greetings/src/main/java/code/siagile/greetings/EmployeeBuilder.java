package code.siagile.greetings;

import java.util.*;

public class EmployeeBuilder {
	public static Employee employee(String string) {
		return new EmployeeBuilder(string).newEmployee();
	}

	private String firstName;

	private String lastName;

	private String email;

	private String birthDay;

	public EmployeeBuilder(String string) {
		Scanner scanner = new Scanner(string).useDelimiter(",");
		firstName = clean(scanner.next());
		lastName = clean(scanner.next());
		birthDay = clean(scanner.next());
		email = clean(scanner.next());
	}

	private String clean(String string) {
		if (string == null) return "";
		return string.trim();
	}

	public Employee newEmployee() {
		return new Employee(firstName, lastName, birthDay, email);
	}
}
