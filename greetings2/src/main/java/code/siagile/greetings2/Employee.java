package code.siagile.greetings2;

import static ch.lambdaj.Lambda.*;
import static java.util.Arrays.*;

public class Employee {

	private String email;
	
	private String birthDay;
	
	private String lastName;

	private String firstName;

	public Employee(String firstName, String lastName, String birthDay, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDay = birthDay;
		this.email = email;
	}

	public boolean wasBorn(String today) {
		return birthDay.replaceAll("\\d{4}$", "").equals(today.replaceAll("\\d{4}$", ""));
	}

	public String birthdayHimself() {
		return join(asList("Happy birthday", firstName), " ");
	}
	
}
