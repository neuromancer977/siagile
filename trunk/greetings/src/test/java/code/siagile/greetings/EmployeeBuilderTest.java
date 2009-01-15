package code.siagile.greetings;

import static org.hamcrest.core.Is.*;
import static org.hamcrest.core.IsEqual.*;
import static org.junit.Assert.*;

import org.junit.*;
import static code.siagile.greetings.EmployeeBuilder.*;

public class EmployeeBuilderTest {

	@Test
	public void testCompareTwoEmployees() {
		Employee employee1 = employee("Doe, John, 1982/10/08, jonh.doe@foobar.com");
		Employee employee2 = employee("Doe, John, 1982/10/08, jonh.doe@foobar.com");

		assertThat(employee1, is(equalTo(employee2)));
	}
}