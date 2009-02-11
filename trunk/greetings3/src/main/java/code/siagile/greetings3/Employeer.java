package code.siagile.greetings3;

import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.hamcrest.Matcher;

public class Employeer {

	final MailAgent mailAgent;

	private final EmployeesReader employeesReader;

	private List<Employee> employees = new LinkedList<Employee>();

	public Employeer(EmployeesReader employeesReader, MailAgent mailAgent) {
		this.employeesReader = employeesReader;
		this.mailAgent = mailAgent;
	}

	public void employ(InputStream employeesStream) {
		employeesReader.scan(employeesReader.read(employeesStream), this);
	}

	public void employ(String employee) {
		employees.add(scan(employee));
	}

	private void employee(Employee employee, Matcher matcher) {
		mailAgent.send(employee.happyBirthDay());
	}

	private List<Employee> employeesThat(Matcher matcher) {
		List<Employee> matchedEmployees = new LinkedList<Employee>();

		for (Employee employee : employees) {
			if (matcher.matches(employee))
				matchedEmployees.add(employee);
		}

		return matchedEmployees;
	}

	private Employee scan(String employeeAsString) {
		Scanner scanner = new Scanner(employeeAsString).useDelimiter(",");

		String firstName = scanner.next().trim();
		String lastName = scanner.next().trim();
		String birthDay = scanner.next().trim();
		String email = scanner.next().trim();

		return new Employee(firstName, lastName, birthDay, email);
	}

	public void sendHappyBirthdayToEmployees(Matcher match) {
		for (Employee employee : employeesThat(match)) {
			employee(employee, match);
		}
	}
}