package code.siagile.greetings;

import static code.siagile.greetings.MailBuilder.*;

import java.util.*;

public class MailBox implements Iterable<Mail> {
	private List<Mail> emails = new LinkedList<Mail>();

	public Iterator<Mail> iterator() {
		return emails.iterator();
	}

	public void send(Greeting greeting, Collection<Employee> employees) {
		for (Employee employee : employees) {
			emails.add(mail(greeting, employee));
		}
	}
}
