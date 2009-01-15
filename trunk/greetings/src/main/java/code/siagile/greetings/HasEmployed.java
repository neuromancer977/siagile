package code.siagile.greetings;

import org.hamcrest.*;

public class HasEmployed {
	public static final Matcher<Employer> hasEmployed(final Employee employee) {
		return new BaseMatcher<Employer>() {
			public void describeTo(Description description) {
				description.appendText(employee + " unknown");
			}

			public boolean matches(Object object) {
				return ((Employer) object).hasEmployed(employee);
			}
		};
	}
}
