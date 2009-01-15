package code.siagile.greetings;

import static ch.lambdaj.Lambda.*;
import static java.util.Arrays.*;

public class Greeting {
	private String name;

	private String greeting;

	public static final Greeting HappyBirthDay = new Greeting("Happy birth day");

	public static String happy(String day, Employee employee) {
		Greeting greeting = new Greeting("Happy", day);
		employee.greeting(greeting);
		return greeting.toString();
	}

	private Greeting(String greeting) {
		this.greeting = greeting;
	}

	private Greeting(String greeting, String day) {
		this.greeting = join(asList(greeting, day), " ");
	}

	public void greeting(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return join(asList(greeting, name));
	}

}
