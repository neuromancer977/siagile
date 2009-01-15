package code.siagile.greetings;

public class EmployerBuilder {
	private MailBox mailBox = new MailBox();

	public EmployerBuilder(MailBox mailBox) {
		this.mailBox = mailBox;
	}

	public Employer newEmployer() {
		return new Employer(mailBox);
	}
}
