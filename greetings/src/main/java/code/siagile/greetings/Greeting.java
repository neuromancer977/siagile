package code.siagile.greetings;

import static ch.lambdaj.Lambda.*;
import static java.util.Arrays.*;

public class Greeting {
	private String name;

	private String greeting;

	protected Greeting(String greeting, String day, String name) {
		this.greeting = join(asList(greeting, day), " ");
		this.name = name;
	}
	
	protected Greeting() {}

	public Greeting greeting(String name) {
		this.name = name;
		return this;
	}

	@Override
	public String toString() {
		return join(asList(greeting, name));
	}

}
