package code.siagile.greetings;

import static code.siagile.greetings.EmployeeBuilder.*;
import static org.hamcrest.core.Is.*;
import static org.hamcrest.core.IsEqual.*;
import static org.junit.Assert.*;

import org.junit.*;

public class EmployeeBuilderTest {

	@Test
	public void testCompareTwoEmployees() {
		Employee employee1 = employeeFrom("Doe, John, 1982/10/08, jonh.doe@foobar.com");
		Employee employee2 = employeeFrom("Doe, John, 1982/10/08, jonh.doe@foobar.com");

		assertThat(employee1, is(equalTo(employee2)));
	}
}