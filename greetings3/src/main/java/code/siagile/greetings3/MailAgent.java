package code.siagile.greetings3;

import java.util.LinkedList;
import java.util.List;

public class MailAgent {

	private List<Message> messages = new LinkedList<Message>();

	public boolean hasSendMessage(Message message) {
		return messages.contains(message);
	}

	public void send(Message message) {
		messages.add(message);
	}

}
