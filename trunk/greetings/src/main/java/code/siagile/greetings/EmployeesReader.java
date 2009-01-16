package code.siagile.greetings;

import static code.siagile.greetings.EmployeeBuilder.*;

import java.util.*;

public class EmployeesReader implements Iterable<Employee> {

	private List<Employee> employees = new LinkedList<Employee>();

	public EmployeesReader(String strings) {
		for (String string : new SplittedStrings(strings))
			employees.add(employeeFrom(string));
	}

	public Iterator<Employee> iterator() {
		return employees.iterator();
	}

}
