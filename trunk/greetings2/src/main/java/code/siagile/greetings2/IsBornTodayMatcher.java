package code.siagile.greetings2;

import org.hamcrest.*;

public class IsBornTodayMatcher extends BaseMatcher<Employee> {

	private final String today;

	public IsBornTodayMatcher(String today) {
		this.today = today;
	}

	public void describeTo(Description description) {
		description.appendText("is not born " + today);
	}

	public boolean matches(Object object) {
		return ((Employee) object).wasBorn(today);
	}
}
