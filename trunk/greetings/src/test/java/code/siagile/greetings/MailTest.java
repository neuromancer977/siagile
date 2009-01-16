package code.siagile.greetings;

import static code.siagile.greetings.EmployeeBuilder.*;
import static code.siagile.greetings.MailBuilder.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.*;

public class MailTest {
	@Test
	public void testMailToEmployee() {
		Employee John = employeeFrom("Doe, John, 1982/10/08, jonh.doe@foobar.com");

		assertThat(mail(new HappyBirthDayGreeting(), John).toString(), is(equalTo("Happy birth day Doe!, jonh.doe@foobar.com")));
	}
}
