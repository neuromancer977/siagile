package code.siagile.greetingssingleif;

import static code.siagile.greetingssingleif.IsBornToday.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.*;

public class IsBornTodayTest {
	@Test
	public void testEmployeeIsBornToday() {
		Employee employee1 = Employees.createNewFrom("John, Smith, 4/01/1970, joe.smith@gmail.com");
		Employee employee2 = Employees.createNewFrom("Alice, Smith, 23/11/1975, alice.smith@gmail.com");

		assertThat(employee1, is(born("4/01/yyyy")));
		assertThat(employee1, is(not(born("23/11/yyyy"))));
	}

	@Test
	public void testEmployeeIsBornIgnoreYear() {
		assertThat(IsBornToday.ignoreYear("01/01/0001"), is(equalTo("01/01")));
	}

	@Test
	public void testEmployeeIsBornBirthDay() {
		assertThat(IsBornToday.birthDay("first, second, 01/01/0001, four"), is(equalTo("01/01")));
	}
}
