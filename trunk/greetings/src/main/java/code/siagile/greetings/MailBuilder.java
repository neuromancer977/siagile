package code.siagile.greetings;


public class MailBuilder {
	public static Mail mail(Greeting greeting, Employee employee) {
		return new MailBuilder(greeting).to(employee).newMail();
	}

	private Greeting greeting;

	private EmailAddress to = new EmailAddress();

	private String withMessage;

	public MailBuilder(Greeting greeting) {
		this.greeting = greeting;
	}

	private Mail newMail() {
		return new Mail(to, withMessage);
	}

	private MailBuilder to(Employee employee) {
		withMessage = employee.greeting(greeting).toString();
		employee.email(to);
		return this;
	}
}
