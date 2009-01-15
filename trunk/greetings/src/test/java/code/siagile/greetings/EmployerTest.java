package code.siagile.greetings;

import static code.siagile.greetings.EmployeeBuilder.*;
import static code.siagile.greetings.HasEmployed.*;
import static org.junit.Assert.*;

import org.junit.*;

public class EmployerTest {
	@Test
	public void testEmployer() {
		Employee John = employee("Doe, John, 1982/10/08, jonh.doe@foobar.com");
		Employee Alice = employee("Doe, Alice, 1980/04/03, alice.doe@foobar.com");

		Employer employer = new EmployerBuilder(new MailBox()).newEmployer();

		employer.employ(John, Alice);

		assertThat(employer, hasEmployed(John));
		assertThat(employer, hasEmployed(Alice));
	}
}