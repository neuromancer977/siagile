package code.siagile.greetings;

public class HappyBirthDayGreeting extends Greeting {
	@Override
	public Greeting greeting(String name) {
		return new Greeting("Happy", "birth day", name);
	}

}
