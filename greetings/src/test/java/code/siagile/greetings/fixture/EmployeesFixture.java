package code.siagile.greetings.fixture;

import static ch.lambdaj.Lambda.*;
import static code.siagile.greetings.EmployeeBuilder.*;
import static java.util.Arrays.*;

import java.util.*;

import code.siagile.greetings.*;
import fit.*;

public class EmployeesFixture extends ColumnFixture {
	public String firstName;
	public String lastName;
	public String birthDay;
	public String email;

	public String today;

	public String row;
	
	public static final List<Employee> employees = new LinkedList<Employee>();

	public boolean canReadRow() {
		try {
			employeeFrom(row);
			return true;
		} catch (RuntimeException e) {
			return false;
		}
	}

	public boolean isAdded() {
		Employee employee = employeeFrom(join(asList(firstName, lastName, birthDay, email)));
		employees.add(employee);
		return employees.contains(employee);
	}

	public boolean isBornToday() {
		Employee employee = employeeFrom(join(asList(firstName, lastName, birthDay, email)));
		return new EmployeeIsBorn(today).matches(employee);
	}
}
