package code.siagile.greetings2;

import org.junit.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.matchers.IsCollectionContaining.*;
import static org.junit.Assert.*;

public class BirtdayGreetingsTest {
	private Employee johnDoe;
	private Employee employee2;
	private MailBox mailBox;
	private Employer employeer;

	@Before
	public void setUp() {
		johnDoe = new EmployeeBuilder().employee("John, Doe, 13/02/1975, john.doe@foobar.com");
		employee2 = new EmployeeBuilder().employee("Alice, Doe, 13/02/1980, alice.doe@foobar.com");
		mailBox = new MailBox();
		employeer = new Employer(mailBox);
		employeer.employ(employee2);
	}

	@Test
	public void testWasBorn() {
		assertThat(johnDoe.wasBorn("13/02/1975"), is(true));
	}
	
	@Test
	public void testSendBirthdayMessageToEmployeesBornToday() {
		String today = "13/02/2009";
		
		employeer.sendBirtdayGreetingTo(born(today));
		
		assertThat(mailBox, hasItems("Happy birthday John"));
		assertThat(mailBox, hasItems("Happy birthday Alice"));
	}

	@Test
	public void testSendBirthdayMessageToEmployeesBornTodayButNotToOthers() {
		String today = "13/02/2009";

		Employee employee3 = new EmployeeBuilder().employee("Neal, Doe, 13/05/1975, neal.doe@foobar.com");
		Employee employee4 = new EmployeeBuilder().employee("Duffy, Doe, 17/02/1975, duffy.doe@foobar.com");
		
		employeer.employ(employee3);
		employeer.employ(employee4);
		
		employeer.sendBirtdayGreetingTo(born(today));
		
		assertThat(mailBox, not(hasItems("Happy birthday Neal")));
		assertThat(mailBox, not(hasItems("Happy birthday Duffy")));
	}

	private IsBornTodayMatcher born(String today) {
		return new IsBornTodayMatcher(today);
	}
}
