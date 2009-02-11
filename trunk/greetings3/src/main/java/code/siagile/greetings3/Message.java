package code.siagile.greetings3;

public class Message {

	private final String message;

	private final String email;

	public Message(String message, String email) {
		this.message = message;
		this.email = email;
	}

	@Override
	public boolean equals(Object obj) {
		Message anotherMessage = (Message) obj;
		if (!anotherMessage.message.equalsIgnoreCase(message))
			return false;
		if (!anotherMessage.email.equalsIgnoreCase(email))
			return false;
		return true;
	}

}
