package code.siagile.greetings;

import static code.siagile.greetings.EmployeeBuilder.*;
import static code.siagile.greetings.Greeting.*;
import static org.junit.Assert.*;
import static org.junit.matchers.StringContains.*;

import org.junit.*;

public class GreetingTest {
	@Test
	public void testGreeting() {
		Employee Doe = employee("Doe, John, 1982/10/08, jonh.doe@foobar.com");

		assertThat(happy("birthday", Doe).toString(), containsString("Happy birthday, Doe"));
	}
}