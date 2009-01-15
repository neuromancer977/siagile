package code.siagile.greetings;

import static ch.lambdaj.Lambda.*;
import static code.siagile.greetings.EmployeeBuilder.*;
import static code.siagile.greetings.EmployeeIsBorn.*;
import static code.siagile.greetings.Greeting.*;
import static code.siagile.greetings.MailBuilder.*;
import static java.util.Arrays.*;
import static org.junit.matchers.IsCollectionContaining.*;
import static org.junit.Assert.*;

import org.junit.*;

public class HappyBirthdayEmployeesBornToday {
	@Test
	public void testHappyBirthdayEmployeesBornToday() {
		Employee John = employee("Doe, John, 1982/10/08, jonh.doe@foobar.com");
		Employee Alice = employee("Doe, Alice, 1980/04/03, alice.doe@foobar.com");
		Iterable<Employee> employees = asList(John, Alice);
		String today = "1982/10/08";
		MailBox mailBox = new MailBox();
		Mail mailToJohn = mail(HappyBirthDay, John);

		mailBox.send(HappyBirthDay, to(employees, born(today)));

		assertThat(mailBox, hasItems(mailToJohn));
	}
}