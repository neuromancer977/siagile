package code.siagile.greetings;

import static code.siagile.greetings.EmployeeBuilder.*;
import static code.siagile.greetings.EmployeeIsBorn.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.*;

public class IsBornTest {
	@Test
	public void testEmployeeIsBornToday() {
		assertThat(employeeFrom("Doe, John, 1982/10/08, jonh.doe@foobar.com"), is(born("2008/10/08")));
		assertThat(employeeFrom("Doe, John, 0000/00/00, jonh.doe@foobar.com"), is(not(born("2008/10/08"))));
	}
}
