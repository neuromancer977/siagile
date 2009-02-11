package code.siagile.greetings2;

import java.util.*;
import static ch.lambdaj.Lambda.*;
import static org.hamcrest.core.Is.*;;

public class Employer {

	private List<Employee> employees = new LinkedList<Employee>();
	
	private MailBox mailBox;

	public Employer(MailBox mailBox) {
		this.mailBox = mailBox;
	}

	public void employ(Employee employee) {
		employees.add(employee);
	}

	public void sendBirtdayGreetingTo(IsBornTodayMatcher bornToday) {
		Collection<Employee> employessBornToday = select(forEach(employees), is(bornToday));
		
		for(Employee employeeBornToday: employessBornToday) {
			mailBox.addEmail(employeeBornToday.birthdayHimself());
		}
	}

}
