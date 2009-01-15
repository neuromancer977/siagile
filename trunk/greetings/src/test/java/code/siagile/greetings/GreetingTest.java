package code.siagile.greetings;

import static code.siagile.greetings.EmployeeBuilder.*;
import static org.junit.Assert.*;
import static org.junit.matchers.StringContains.*;

import org.junit.*;

public class GreetingTest {
	@Test
	public void testGreeting() {
		Employee Doe = employee("Doe, John, 1982/10/08, jonh.doe@foobar.com");

		Greeting greeting = Doe.greeting(new HappyBirthDayGreeting());
		
		assertThat(greeting.toString(), containsString("Happy birth day, Doe"));
	}

	@Test
	public void testGreetingMe() {
			assertThat(new Greeting().greeting("me").toString(), containsString("me"));
	}
}