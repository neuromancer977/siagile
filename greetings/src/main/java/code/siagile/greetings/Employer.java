package code.siagile.greetings;

import static ch.lambdaj.Lambda.*;
import static java.util.Arrays.*;

import java.util.*;

import org.hamcrest.*;

public class Employer implements Iterable<Employee> {
	private List<Employee> employds = new LinkedList<Employee>();

	private MailBox mailBox = new MailBox();

	public Employer(MailBox mailBox) {
		this.mailBox = mailBox;
	}

	public void employ(Employee... newEmployeds) {
		employ(asList(newEmployeds));
	}

	public void employ(Iterable<Employee> newEmployeds) {
		for (Employee newEmployee : newEmployeds)
			this.employds.add(newEmployee);
	}

	public boolean hasEmployed(Employee possibleEmployed) {
		return employds.contains(possibleEmployed);
	}

	public Iterator<Employee> iterator() {
		return employds.iterator();
	}

	@SuppressWarnings("unchecked")
	public void sendHappyBirthDayEmailTo(Matcher employeeMatcher) {
		mailBox.send(new HappyBirthDayGreeting(), to(this, employeeMatcher));
	}

}
