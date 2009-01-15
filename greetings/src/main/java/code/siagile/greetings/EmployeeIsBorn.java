package code.siagile.greetings;

import org.hamcrest.*;

public class EmployeeIsBorn extends BaseMatcher<Employee> {
	public static final EmployeeIsBorn born(String atDate) {
		return new EmployeeIsBorn(atDate);
	}

	private String atThisDate;

	public EmployeeIsBorn(String birthDay) {
		this.atThisDate = birthDay;
	}

	public void describeTo(Description description) {
		description.appendText("is not born " + atThisDate);
	}

	public boolean matches(Object object) {
		return ((Employee) object).wasBorn(atThisDate);
	}
}
