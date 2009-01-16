package code.siagile.greetings.fixture;

import static ch.lambdaj.Lambda.*;
import static code.siagile.greetings.EmployeeIsBorn.*;
import static code.siagile.greetings.fixture.EmployeesFixture.*;
import code.siagile.greetings.*;
import fitlibrary.*;

public class EmployeerFixture extends DoFixture {
	public boolean sendToEmployeesBorn(String greeting, String today) {
		String strings = join(employees, "\n");
		EmployeesReader employeesReader = new EmployeesReader(strings);
		Employer employer = new Employer(MailBoxFixture.mailBox);
		employer.employ(employeesReader);
		if (greeting.contains("happy birthday")) employer.sendHappyBirthDayEmailTo(born(today));
		return true;
	}
}
