package code.siagile.greetings3;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

public class IsBornAt extends BaseMatcher<Employee> {
	private String atDate;

	public IsBornAt(String date) {
		this.atDate = date;
	}

	public void describeTo(Description description) {
		description.appendText("was not born " + atDate);
	}

	public boolean matches(Object item) {
		return ((Employee) item).wasBorn(atDate);
	}
}
