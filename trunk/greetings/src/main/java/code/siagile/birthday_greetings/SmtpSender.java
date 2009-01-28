package code.siagile.birthday_greetings;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SmtpSender implements Sender {
	private static final String SENDER = "sender@here.com";
	private String host;
	private int port;

	public SmtpSender(String host, int port) {
		this.host=host;
		this.port=port;
	}

	public void send(IMessage greetingsMessage) {
		try {
			sendMessage(host, port, SENDER, greetingsMessage);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


	private void sendMessage(String smtpHost, int smtpPort, String sender, IMessage greetingsMessage)
			throws AddressException, MessagingException {

		Message smtpMessage = createMessage(smtpHost, smtpPort);
		smtpMessage.setFrom(new InternetAddress(sender));
		buildMessage(greetingsMessage, smtpMessage);
		Transport.send(smtpMessage);
	}

	private void buildMessage(IMessage greetingsMessage, Message smtpMessage) throws MessagingException,
			AddressException {
		smtpMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(greetingsMessage.getReceiver()));
		smtpMessage.setSubject(greetingsMessage.getSubject());
		smtpMessage.setText(greetingsMessage.getBody());
	}

	private Message createMessage(String smtpHost, int smtpPort) {
		java.util.Properties props = new java.util.Properties();
		props.put("mail.smtp.host", smtpHost);
		props.put("mail.smtp.port", "" + smtpPort);
		Session session = Session.getDefaultInstance(props, null);
		return new MimeMessage(session);
	}

}
