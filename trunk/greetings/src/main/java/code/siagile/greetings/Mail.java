package code.siagile.greetings;

import static ch.lambdaj.Lambda.*;
import static java.util.Arrays.*;

public class Mail {
	private EmailAddress to;

	private String message;

	public Mail(EmailAddress to, String message) {
		this.to = to;
		this.message = message;
	}

	@Override
	public boolean equals(Object obj) {
		Mail anotherMail = (Mail) obj;
		if (!to.equals(anotherMail.to)) return false;
		if (!message.equals(anotherMail.message)) return false;
		return true;
	}

	@Override
	public String toString() {
		return join(asList(message, to.toString()));
	}

}
