package code.siagile.greetingssingleif;

import java.util.*;

import org.hamcrest.*;

public class IsBornToday extends BaseMatcher<Employee> {
	private String today;

	public void describeTo(Description description) {
		description.appendText("is not born " + today);
	};
	
	public IsBornToday(String string) {
		today = ignoreYear(string);
	}

	public boolean matches(Object object) {
		String string = object.toString();
		String birthDay = birthDay(string);
		return birthDay.equals(today);
	}

	public static String ignoreYear(String string) {
		return string.replaceAll("/....$", "");
	};

	public static String birthDay(String string) {
		Scanner scanner = new Scanner(string).useDelimiter(",");
		scanner.next();
		scanner.next();
		return ignoreYear(scanner.next().trim());
	};

	@Factory
	public static Matcher born(String string) {
		return new IsBornToday(string);
	}

}
