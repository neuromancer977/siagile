package code.siagile.greetings;

import static ch.lambdaj.Lambda.*;
import static java.util.Arrays.*;

public class Employee {
	private String firstName = "";

	private String lastName = "";

	private String birthDay = "";

	private String email = "";

	protected Employee(String firstName, String lastName, String birthDay, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDay = birthDay;
		this.email = email;
	}

	public void email(EmailAddress email) {
		email.email(this.email);
	}

	@Override
	public boolean equals(Object obj) {
		Employee anotherEmployee = (Employee) obj;
		if (!firstName.equals(anotherEmployee.firstName)) return false;
		if (!lastName.equals(anotherEmployee.lastName)) return false;
		if (!wasBorn(anotherEmployee.birthDay)) return false;
		if (!email.equals(anotherEmployee.email)) return false;
		return true;
	}

	public void greeting(Greeting greeting) {
		greeting.greeting(firstName);
	}

	@Override
	public String toString() {
		return join(asList(firstName, lastName, birthDay, email));
	}

	public boolean wasBorn(String date) {
		return birthDay.equals(date);
	}
}
