package code.siagile.birthday_greetings;

import java.util.List;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SmtpSender implements Sender {
	private static final String SENDER = "sender@here.com";
	private Session session;

	public SmtpSender(String host, int port) {
		session = createSession(host, port);
	}
	
	public void send(List<Employee> employees) {
		for (Employee employee : employees) {
			IMessage greetingsMessage = new GreetingMessage(employee);
			send(greetingsMessage);
		}
	}


	private void send(IMessage greetingsMessage) {
		try {
			sendMessage(SENDER, greetingsMessage);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void sendMessage(String sender, IMessage greetingsMessage)
			throws AddressException, MessagingException {

		Message smtpMessage = new MimeMessage(session);
		smtpMessage.setFrom(new InternetAddress(sender));
		buildMessage(greetingsMessage, smtpMessage);
		Transport.send(smtpMessage);
	}

	private void buildMessage(IMessage greetingsMessage, Message smtpMessage) throws MessagingException,
			AddressException {
		smtpMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(greetingsMessage.receiver()));
		smtpMessage.setSubject(greetingsMessage.subject());
		smtpMessage.setText(greetingsMessage.body());
	}

	private Session createSession(String smtpHost, int smtpPort) {
		java.util.Properties props = new java.util.Properties();
		props.put("mail.smtp.host", smtpHost);
		props.put("mail.smtp.port", "" + smtpPort);
		Session session = Session.getDefaultInstance(props, null);
		return session;
	}

}
