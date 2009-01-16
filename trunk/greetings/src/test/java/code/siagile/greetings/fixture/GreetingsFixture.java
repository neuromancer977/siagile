package code.siagile.greetings.fixture;

import code.siagile.greetings.*;
import fit.*;

public class GreetingsFixture extends ColumnFixture {
	public String name;
	
	public String happyBirthDay() {
		return new HappyBirthDayGreeting().greeting(name).toString();
	}
}
