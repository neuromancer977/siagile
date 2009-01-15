package code.siagile.greetings;

import static ch.lambdaj.Lambda.*;
import static java.util.Arrays.*;

public class Greeting {
	private String name;

	private String greeting;

	public static final Greeting HappyBirthDay = new Greeting() {
		@Override
		public Greeting greeting(String name) {
			return new Greeting("Happy", "birth day", name);
		}
	};

	private Greeting(String greeting, String day) {
		this.greeting = join(asList(greeting, day), " ");
	}

	private Greeting(String greeting, String day, String name) {
		this.greeting = join(asList(greeting, day), " ");
		this.name = name;
	}

	private Greeting() {}

	public Greeting greeting(String name) {
		this.name = name;
		return this;
	}

	@Override
	public String toString() {
		return join(asList(greeting, name));
	}

}
