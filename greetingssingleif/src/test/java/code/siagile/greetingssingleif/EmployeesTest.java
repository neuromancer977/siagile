package code.siagile.greetingssingleif;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.*;

public class EmployeesTest {
	@Test
	public void testEmployeeFromString() {
		Employee employee1 = Employees.createNewFrom("Luca, Marrocco, 4/12/1980, luca.marrocco@gmail.com");
		Employee employee2 = Employees.createNewFrom(employee1.toString());

		assertThat(employee1, is(equalTo(employee2)));
	}
}
