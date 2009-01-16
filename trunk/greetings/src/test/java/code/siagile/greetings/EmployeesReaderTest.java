package code.siagile.greetings;

import static code.siagile.greetings.EmployeeBuilder.*;
import static org.junit.Assert.*;
import static org.junit.matchers.IsCollectionContaining.*;

import org.junit.*;

public class EmployeesReaderTest {
	@Test
	public void testCreateSomeEmployeesFromStrings() {
		Employee Alice = employeeFrom("Doe, Alice, 1980/04/03, alice.doe@foobar.com");
		Employee John = employeeFrom("Doe, John, 1982/10/08, jonh.doe@foobar.com");

		String AliceAndJohn = Alice.toString() + "\n" + John.toString();

		Iterable<Employee> employees = new EmployeesReader(AliceAndJohn);

		assertThat(employees, hasItem(Alice));
		assertThat(employees, hasItem(John));
	}

}
