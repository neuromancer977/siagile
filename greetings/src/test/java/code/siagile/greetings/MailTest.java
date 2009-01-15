package code.siagile.greetings;

import static code.siagile.greetings.EmployeeBuilder.*;
import static org.junit.Assert.*;
import static code.siagile.greetings.Greeting.*;
import static org.hamcrest.CoreMatchers.*;
import static code.siagile.greetings.MailBuilder.*;
import org.junit.*;

public class MailTest {
	@Test
	public void testMailToEmployee() {
		Employee John = employee("Doe, John, 1982/10/08, jonh.doe@foobar.com");

		assertThat(mail(HappyBirthDay, John).toString(), is(equalTo("Happy birth day, Doe, jonh.doe@foobar.com")));
	}
}
