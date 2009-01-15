package code.siagile.greetings;

import static code.siagile.greetings.EmployeeBuilder.*;
import static code.siagile.greetings.EmployeeIsBorn.*;
import static code.siagile.greetings.Greeting.*;
import static code.siagile.greetings.MailBuilder.*;
import static org.junit.Assert.*;
import static org.junit.matchers.IsCollectionContaining.*;

import org.junit.*;

public class MainTest {
	@Test
	public void testSendEmailToEmployeeBornToday() {
		String employees = "";
		employees += "Doe, John, 1982/10/08, jonh.doe@foobar.com\n";
		employees += "Doe, Alice, 1980/04/03, alice.doe@foobar.com\n";
		employees += "Smith, Dan, 1975/03/02, snith.dan@foobar.com\n";
		MailBox mailBox = new MailBox();
		String today = "1982/10/08";

		Employer foobarDotCom = new Employer(mailBox);
		foobarDotCom.employ(new EmployeesReader(employees));
		foobarDotCom.sendHappyBirthDayEmailTo(born(today));

		Mail mailToJohn = mail(HappyBirthDay, employee("Doe, John, 1982/10/08, jonh.doe@foobar.com\n"));

		assertThat(mailBox, hasItems(mailToJohn));

	}
}
