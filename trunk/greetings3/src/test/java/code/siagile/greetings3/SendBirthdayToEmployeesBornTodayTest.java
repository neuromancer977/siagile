package code.siagile.greetings3;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.InputStream;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;

public class SendBirthdayToEmployeesBornTodayTest {
	private static final String AliceSmith = "Alice, Smith, 11/01/1980, alice.smith@foobar.com";
	private static final String PeterAlone = "Peter, Alone, 12/02/1980, peter.alone@foobar.com";
	private static final String JohnDoe = "John, Doe, 11/02/1980, john.doe@foobar.com";

	private static final Message happyBirthDayAlice = new Message("Happy birthday Alice!", "alice.doe@foobar.com");
	private static final Message happyBirthDayJohn = new Message("Happy birthday John!", "john.doe@foobar.com");
	private static final Message happyBirthDayPeter = new Message("Happy birthday Peter!", "peter.alone@foobar.com");

	private String today;

	private MailAgent mailAgent;
	private Employeer employeer;
	private EmployeesReader employeesReader;
	private InputStream employees;

	private Matcher born(String date) {
		return new IsBornAt(date);
	}

	@Before
	public void setUp() {
		today = "11/02/2009";
		mailAgent = new MailAgent();
		employeesReader = new EmployeesReader();
		employeer = new Employeer(employeesReader, mailAgent);
		employees = getClass().getResourceAsStream("Employees.txt");
	}

	@Test
	public void testDoNotSendHappyBirthdayToEmployeesThatWasntBornToday() {
		employeer.employ(PeterAlone);
		employeer.employ(AliceSmith);

		employeer.sendHappyBirthdayToEmployees(born(today));

		assertThat(mailAgent.hasSendMessage(happyBirthDayPeter), is(false));
		assertThat(mailAgent.hasSendMessage(happyBirthDayAlice), is(false));
	}

	@Test
	public void testEmployeesToday() {
		employeer.employ(employees);

		employeer.sendHappyBirthdayToEmployees(born(today));

		assertThat(mailAgent.hasSendMessage(happyBirthDayJohn), is(true));
	}

	@Test
	public void testMailAgentHasSendedMessage() {
		Message message1 = happyBirthDayJohn;
		Message message2 = happyBirthDayAlice;

		mailAgent.send(message1);

		assertThat(mailAgent.hasSendMessage(message1), is(true));
		assertThat(mailAgent.hasSendMessage(message2), is(false));
	}

	@Test
	public void testSendHappyBirthdayToEmployeesBornToday() {
		employeer.employ(JohnDoe);

		employeer.sendHappyBirthdayToEmployees(born(today));

		assertThat(mailAgent.hasSendMessage(happyBirthDayJohn), is(true));
	}

	@Test
	public void testTwoMessageAreEquals() {
		Message message1 = happyBirthDayJohn;
		Message message2 = happyBirthDayJohn;

		assertThat(message1, is(equalTo(message2)));
	}
}