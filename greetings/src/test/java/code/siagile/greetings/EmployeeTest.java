package code.siagile.greetings;

import static code.siagile.greetings.EmployeeBuilder.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.*;

public class EmployeeTest {
	@Test
	public void testToString() {
		assertThat(employeeFrom("Doe, John, 1982/10/08, jonh.doe@foobar.com").toString(), is(equalTo("Doe, John, 1982/10/08, jonh.doe@foobar.com")));
	}
}
