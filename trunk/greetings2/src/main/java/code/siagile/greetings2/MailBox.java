package code.siagile.greetings2;

import java.util.*;

public class MailBox implements Iterable<String> {
	private List<String> emails = new LinkedList<String>();
	
	public void addEmail(String email) {
		emails.add(email);
	}
	
	public Iterator<String> iterator() {
		return emails.iterator();
	}
	
	@Override
	public String toString() {
		return emails.toString();
	}
}
