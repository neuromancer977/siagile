package code.siagile.greetings2;

public class EmployeeBuilder {

	public Employee employee(String string) {
		String[] tokens = string.split(",");
		return new Employee(tokens[0], tokens[1], tokens[2].trim(), tokens[3]);
	}

}
